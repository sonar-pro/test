package com.cib.util;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;

public class BuildSql {
	static private BuildSql _instance = null;

    protected BuildSql() {}
    static public BuildSql instance() {
        if (null == _instance) {
            _instance = new BuildSql();
        }
        return _instance;
    }
    /**
     * 通过表名得到表中所有字段sql
     * @param tableName
     * @return sql
     */
    public static String getColsName(String tableName){
    	StringBuffer sql = new StringBuffer("select name from syscolumns where ID=OBJECT_ID('"+tableName+"')");
    	return sql.toString();
    }
    /**
     * 得到一个列值SQL
     * @param tableName
     * @param condition
     * @return
     */
    public static String getOneColValue(String tableName,int id){
    	StringBuffer sql = new StringBuffer("select temp from "+tableName+" where id = "+id);
    	return sql.toString();
    }
    /**
     * 得到一个列值SQL
     * @param tableName
     * @param condition
     * @return
     */
    public static String getOneColValue(String tableName,String condition){
    	StringBuffer sql = new StringBuffer("select temp from "+tableName+" where "+condition);
    	return sql.toString();
    }
    /**
     * 添加数据SQL
     * @param tableName 要添加数据的表名
     * @param map 要添加数据的列名和对应值
     * @return sql 
     */
    public static String add(String tableName ,Map map){
    	Iterator it = map.entrySet().iterator();  
    	StringBuffer keys = new StringBuffer("");
    	StringBuffer values = new StringBuffer("");
		while (it.hasNext()){     
			Map.Entry entry = (Map.Entry)it.next();     
			String key = (String)entry.getKey();     
			String value = (String)entry.getValue();
			if(keys.length()==0||values.length()==0){
				keys.append(key);
				values.append(value);
			}else{
				keys.append(","+key);
				values.append(","+value);
			}
		}
    	StringBuffer sql = new StringBuffer("insert into "+tableName+" ("+keys+") values ("+values+")");
    	return sql.toString();
    }
    public static String add(String tableName ,String colsName,String colsValue){
    	StringBuffer sql = new StringBuffer("insert into "+tableName+" ("+colsName+") values ("+colsValue+")");
    	return sql.toString();
    }
    
    /**
     * 根据表名和表主键ID拼接SQL语句
     * @param tableName
     * @param id
     * @return sql
     */
    public static String delete(String tableName,int id) { 
    	StringBuffer sql = new StringBuffer("delete from "+tableName+" where id = "+id);
    	return sql.toString();
    }
    /**
     * 根据表名和删除条件拼接SQL语句
     * @param tableName
     * @param id
     * @return sql
     */
    public static String delete(String tableName,String condition) { 
    	StringBuffer sql = new StringBuffer("delete from "+tableName+" where "+condition);
    	return sql.toString();
    }
    /**
     * 根据表名和表多个主键ID以及要删除的where条件拼接SQL语句
     * @param tableName
     * @param ids  为多个id以","号分隔
     * @param condition 其他条件
     * @return sql
     */
    public static String delete(String tableName,String ids,String condition) { 
    	StringBuffer sql = new StringBuffer("delete from "+tableName+" where id in ("+ids+")");
    	if(!"".equals(condition)){
    		sql.append(" and "+condition);
    	}
    	return sql.toString();
    }
    /**
     * 根据给定ID拼接更新表SQL
     * @param tableName
     * @param map
     * @param id
     * @return sql
     */
    public static String update(String tableName,Map map,int id){
    	Iterator it = map.entrySet().iterator();  
    	StringBuffer setvalue = new StringBuffer("");
		while (it.hasNext()){     
			Map.Entry entry = (Map.Entry)it.next();     
			String field = (String)entry.getKey();     
			String value = (String)entry.getValue();
			if(setvalue.length()==0){
				setvalue.append(field+"="+value);
			}else{
				setvalue.append(","+field+"="+value);
			}
		}
    	StringBuffer sql = new StringBuffer("update "+tableName+" set "+setvalue+" where id="+id);
    	return sql.toString();
    }
    /**
     * 根据给定条件拼接更新表SQL
     * @param tableName
     * @param map
     * @param condition
     * @return sql
     */
    public static String update(String tableName,Map map,String condition){
    	Iterator it = map.entrySet().iterator();  
    	StringBuffer setvalue = new StringBuffer("");
		while (it.hasNext()){     
			Map.Entry entry = (Map.Entry)it.next();     
			String field = (String)entry.getKey();     
			String value = (String)entry.getValue();
			if(setvalue.length()==0){
				setvalue.append(field+"="+value);
			}else{
				setvalue.append(","+field+"="+value);
			}
		}
    	StringBuffer sql = new StringBuffer("update "+tableName+" set "+setvalue+" where "+condition);
    	return sql.toString();
    }
    /**
     * 根据给定ID进行查询SQL拼装
     * @param tableName
     * @param id
     * @return
     */
    public static String query(String tableName,int id ,String order){
    	StringBuffer sql = new StringBuffer("select * from "+tableName+" where id = "+id);
    	if(!"".equals(order)){
    		sql.append("order by "+order);
    	}
    	return sql.toString();
    }
    /**
     * 根据给定条件进行查询SQL拼装
     * @param tableName
     * @param condition
     * @return
     */
    public static String query(String tableName,String condition ,String order){
    	StringBuffer sql = new StringBuffer("select * from "+tableName+" where "+condition);
    	if(!"".equals(order)){
    		sql.append("order by "+order);
    	}
    	return sql.toString();
    }
}
