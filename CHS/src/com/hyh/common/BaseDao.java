package com.hyh.common;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyh.annotation.EntityExcept;
import com.hyh.annotation.EntityTable;
import com.hyh.config.Global;
import com.hyh.database.Database;
import com.hyh.util.ClassUtil;
import com.hyh.util.TextUtil;

public class BaseDao<T> {

    private Class<?> entityClass = null; // 反射类
    private Connection connection = null; // 数据库连接
    private PreparedStatement prepareStatement = null; // 预处理
    private ResultSet resultSet = null; // 执行结果
    private String table = null; // 数据库表
    private int count = 0; //计数

    public BaseDao() {
        entityClass = ClassUtil.getClassGenricType(getClass()); // 获取反射类
        table = entityClass.getAnnotation(EntityTable.class).value(); // 获取对应的数据库
    }

    private Connection getConnection() {
        return Database.getConnection();
    }

    /**
     * 插入
     * @param entity
     * @return
     */
    public int insert(T entity) {
        try {
            connection = getConnection(); //数据库连接
            StringBuffer sql = new StringBuffer();
            List<Object> parameters = new ArrayList<Object>();
            boolean isFirst = true;
            Field[] fields = entityClass.getDeclaredFields();
            sql.append("INSERT INTO ");
            sql.append(table);
            sql.append("(");
            for (Field fieldItem : fields) {
                if(fieldItem.getAnnotation(EntityExcept.class) == null){
                    fieldItem.setAccessible(true); //设置些属性是可以访问的
                    String name = fieldItem.getName();
                    Object values = fieldItem.get(entity);
                    if(values == null){
                        continue;
                    }else{
                        name = Global.getConfig("jdbc.prefix") + TextUtil.camelToUnderline(name);
                        parameters.add(fieldItem.get(entity));
                        if(isFirst){
                            sql.append(name);
                            isFirst = false;
                        }else{
                            sql.append(",");
                            sql.append(name);
                        }
                    }
                }
            }
            sql.append(") ");
            sql.append("VALUES(");
            for (int i = 0; i < parameters.size(); i++) {
                if(i == 0){
                    sql.append("?");
                }else{
                    sql.append(",");
                    sql.append("?");
                }
            }
            sql.append(")");
            prepareStatement = connection.prepareStatement(sql.toString());
            count = 0;
            for(Object obj : parameters){
                setValuesOnPrepareStatement(obj);
                count++;
            }
            System.out.println(sql.toString());
            return prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("该属性为空值");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 更新
     * @param entity
     * @return
     */
    public int update(T entity) {
        try {
            connection = getConnection(); //数据库连接
            StringBuffer sql = new StringBuffer();
            String where = " WHERE " + Global.getConfig("jdbc.prefix") + "id = ?";
            Object id = null;
            List<Object> parameters = new ArrayList<Object>();
            boolean isFirst = true;
            Field[] fields = entityClass.getDeclaredFields();
            sql.append("UPDATE ");
            sql.append(table);
            sql.append(" SET ");
            for (Field fieldItem : fields) {
                if(fieldItem.getAnnotation(EntityExcept.class) == null){
                    fieldItem.setAccessible(true); //设置些属性是可以访问的
                    String name = fieldItem.getName();
                    Object values = fieldItem.get(entity);
                    if(values == null){
                        continue;
                    }else if("id".equals(name)){
                        id = values;
                    }else{
                        name = Global.getConfig("jdbc.prefix") + TextUtil.camelToUnderline(name);
                        parameters.add(values);
                        if(isFirst){
                            sql.append(name);
                            sql.append(" = ?");
                            isFirst = false;
                        }else{
                            sql.append(" , ");
                            sql.append(name);
                            sql.append(" = ?");
                        }
                    }
                }
            }
            sql.append(where);
            parameters.add(id);
            prepareStatement = connection.prepareStatement(sql.toString());
            count = 0;
            for(Object obj : parameters){
                setValuesOnPrepareStatement(obj);
                count++;
            }
            System.out.println(sql.toString());
            return prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("该属性为空值");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 删除：通过筛选条件
     * @param where
     * @return
     */
    public int delete(String where) {
        String sql = "DELETE FROM " + table + " WHERE " + where;
        return executeBySql(sql);
    }

    /**
     * 删除：通过Id
     * @param id
     * @return
     */
    public int deleteByID(int id) {
        String where = Global.getConfig("jdbc.prefix")+"id = '" + id + "'";
        return delete(where);
    }

    /**
     * 删除：通过Id
     * @param id
     * @return
     */
    public int deleteByID(String id) {
        String where = Global.getConfig("jdbc.prefix")+"id = '" + id + "'";
        return delete(where);
    }

    /**
     * 执行：添加、更新或删除语句
     * @param sql
     * @return
     */
    public int executeBySql(String sql){
        System.out.println(sql);
        int i = 0;
        try {
            connection = getConnection();
            prepareStatement = connection.prepareStatement(sql);
            i = prepareStatement.executeUpdate(); // 影响行数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询：映射类
     * @param entityClass
     * @param sql
     * @param <K>
     * @return
     */
    public <K> List<K> find(Class<K> entityClass,String sql){
        System.out.println(sql);
        try {
            List<K> list = new ArrayList<K>();
            connection = getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int dataCount = metaData.getColumnCount();
            while (resultSet.next()) {
                K entity = entityClass.newInstance();
                for (int i = 0; i < dataCount; i++) {
                    String key = metaData.getColumnLabel(i + 1);
                    int type = metaData.getColumnType(i + 1);
                    setResultToEntity(key, type ,entity);
                }
                list.add(entity);
            }
            this.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询：无映射类
     * @param sql
     * @return
     */
    public List<Map<String,Object>> find(String sql){
        System.out.println(sql);
        try {
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            connection = getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int dataCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map<String,Object> entity = new HashMap<String,Object>();
                for (int i = 0; i < dataCount; i++) {
                    String key = metaData.getColumnLabel(i + 1);
                    int type = metaData.getColumnType(i + 1);
                    setResultToEntity(key, type ,entity);
                }
                list.add(entity);
            }
            this.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询：单个 有映射类
     * @param entityClass
     * @param sql
     * @param <K>
     * @return
     */
    public <K> K findOne(Class<K> entityClass, String sql){
        System.out.println(sql);
        try {
            connection = getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int dataCount = metaData.getColumnCount();
            K entity = null;
            if (resultSet.next()) {
                entity = entityClass.newInstance();
                for (int i = 0; i < dataCount; i++) {
                    String key = metaData.getColumnLabel(i + 1);
                    int type = metaData.getColumnType(i + 1);
                    setResultToEntity(key, type, entity);
                }
            }
            this.close();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询：单个 无映射类
     * @param sql
     * @return
     */
    public Map<String,Object> findOne(String sql){
        System.out.println(sql);
        try {
            connection = getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int dataCount = metaData.getColumnCount();
            Map<String,Object> entity = null;
            if (resultSet.next()) {
                entity = new HashMap<String,Object>();
                for (int i = 0; i < dataCount; i++) {
                    String key = metaData.getColumnLabel(i + 1);
                    int type = metaData.getColumnType(i + 1);
                    setResultToEntity(key, type ,entity);
                }
            }
            this.close();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 关闭：释放数据库连接
     */
    public void close() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (prepareStatement != null) {
            try {
                prepareStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取列名对应的对象
     * @param key
     * @param type
     * @param entity
     * @return
     * @throws SQLException
     */
    private void setResultToEntity(String key, int type, Object entity) throws SQLException, NoSuchFieldException, IllegalAccessException {
        Object value = null;
        switch (type) {
            case Types.BIGINT:
                value = resultSet.getLong(key);
                break;
            case Types.BOOLEAN:
                value =  resultSet.getBoolean(key);
                break;
            case Types.DATE:
                value =  resultSet.getDate(key);
                break;
            case Types.DOUBLE:
                value =  resultSet.getDouble(key);
                break;
            case Types.DECIMAL:
                value =  resultSet.getDouble(key);
                break;
            case Types.FLOAT:
                value =  resultSet.getFloat(key);
                break;
            case Types.INTEGER:
                value =  resultSet.getInt(key);
                break;
            case Types.SMALLINT:
                value =  resultSet.getInt(key);
                break;
            case Types.TIME:
                value =  resultSet.getTime(key);
                break;
            case Types.TIMESTAMP:
                value =  resultSet.getTimestamp(key);
                break;
            case Types.TINYINT:
                value =  resultSet.getShort(key);
                break;
            case Types.VARCHAR:
                value =  resultSet.getString(key);
                break;
            case Types.NCHAR:
                value =  resultSet.getNString(key);
                break;
            case Types.NVARCHAR:
                value =  resultSet.getNString(key);
                break;
            case Types.BIT:
                value =  resultSet.getByte(key);
                break;
        }
        String name = null;
        if(Global.getConfig("jdbc.prefix").equals(key.substring(0,Global.getConfig("jdbc.prefix").length()))){ //如果列名有前缀就去除
            name = TextUtil.underlineToCamel(key.substring(Global.getConfig("jdbc.prefix").length(),key.length()));
        }else{
            name = TextUtil.underlineToCamel(key);
        }
        if(entity instanceof Map){
            ((Map<String,Object>) entity).put(name,value);
        }else{
            Class<?> entityClazz = entity.getClass();
            Field field = entityClazz.getDeclaredField(name);
            field.setAccessible(true);
            field.set(entity,value);
        }
    }

    /**
     * 读取对象类型，写入数据库预处理
     * @param param
     * @throws SQLException
     */
    private void setValuesOnPrepareStatement(Object param) throws SQLException {
        if (param instanceof Integer) {
            int itg = ((Integer) param).intValue();
            prepareStatement.setInt(count + 1, itg);
        } else if (param instanceof String) {
            String str = (String) param;
            prepareStatement.setString(count + 1, str);
        } else if (param instanceof Double) {
            double dou = ((Double) param).doubleValue();
            prepareStatement.setDouble(count + 1, dou);
        } else if (param instanceof Float) {
            float flo = ((Float) param).floatValue();
            prepareStatement.setFloat(count + 1, flo);
        } else if (param instanceof Long) {
            long lon = ((Long) param).longValue();
            prepareStatement.setLong(count + 1, lon);
        } else if (param instanceof Boolean) {
            boolean boo = ((Boolean) param).booleanValue();
            prepareStatement.setBoolean(count + 1, boo);
        } else if (param instanceof Date) {
            Date date = (Date) param;
            prepareStatement.setTimestamp(count + 1, new java.sql.Timestamp(date.getTime()));
        }
    }
}
