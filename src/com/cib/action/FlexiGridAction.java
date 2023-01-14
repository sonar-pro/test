package com.cib.action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.cib.constant.Constant;
import com.cib.service.ICommonOperationManager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FlexiGridAction extends ActionSupport implements Action{
	
	private ICommonOperationManager commonOperationManager;
	public ICommonOperationManager getCommonOperationManager() {
		return commonOperationManager;
	}
	public void setCommonOperationManager(
			ICommonOperationManager commonOperationManager) {
		this.commonOperationManager = commonOperationManager;
	}
	public void flexGrid() throws Exception {
		ActionContext context = ActionContext.getContext();   
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
        HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
        
        response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		String action = request.getParameter("action");
		System.out.println("action================" + action);
		String sql = "";
		String tableName = "job_info1";
		if("getProvince".equals(action)){
			System.out.println("--------------------getProvince--------------------");
//			String json="[{'provinceID':'110000','province':'北京市'}," +
//					"{'provinceID':'120000','province':'天津市'}," +
//					"{'provinceID':'310000','province':'上海市'}" +
//					"]";
			//String path=this.getServletContext().getRealPath("/")+"province.txt";
			String path=ServletActionContext.getServletContext().getRealPath("/")+"province.txt";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));   
            StringBuffer sb=new StringBuffer();   
            String s;
            while((s=br.readLine())!=null){ 
            	sb.append(s);
            }
            br.close();
            String json=sb.toString();
            System.out.println("json="+json);
            /*
            String xml="<DocumentElement>" +
            		"<table><provinceID>110000</provinceID><province>北京市</province></table>" +
            		"<table><provinceID>120000</provinceID><province>天津市</province></table>" +
            		"<table><provinceID>310000</provinceID><province>上海市</province></table>" +
            		"</DocumentElement>";
            response.getWriter().write(xml);
            */
            /*
            JSONArray array=new JSONArray();
			try {
				for(int i=0;i<5;i++){
					JSONObject object = new JSONObject();
					object.append("provinceID", "11000"+i);
					object.append("province", "北京市"+i);
					array.put(object);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			System.out.println("object="+array.toString());
			response.getWriter().write(array.toString());
			*/
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
			return;
		}
		if("getCity".equals(action)){
			System.out.println("--------------------getCity--------------------");
			String json="";
			String provinceID=request.getParameter("p");
			System.out.println("provinceID="+provinceID);
			if(provinceID.equals("110000")){
				json="[{'cityID':'1','city':'北京'}]";
			}else if(provinceID.equals("120000")){
				json="[{'cityID':'2','city':'天津'}]";
			}
			else if(provinceID.equals("310000")){
				json="[{'cityID':'3','city':'上海'}]";
			}else if(provinceID.equals("130000")){
				json="[{'cityID':'4','city':'石家庄'}," +
					"{'cityID':'5','city':'石家庄2'}"+
					"]";
			}else{
				json="[{'cityID':'-1','city':'请选择城市：'}]";
			}
			System.out.println("object="+json);
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
			return;
		}
		 if ("add".equals(action)) {
			 System.out.println("--------------------add--------------------");
			 String name=java.net.URLDecoder.decode(request.getParameter("name"),"UTF-8");
			 String address=java.net.URLDecoder.decode(request.getParameter("address"),"UTF-8");
			 String salary=java.net.URLDecoder.decode(request.getParameter("salary"),"UTF-8");
			 String date=java.net.URLDecoder.decode(request.getParameter("date"),"UTF-8");
			 String language=java.net.URLDecoder.decode(request.getParameter("language"),"UTF-8");
//			 String name = new String(request.getParameter("name").getBytes("ISO8859_1"),"UTF-8");
//			 String address = new String(request.getParameter("address").getBytes("ISO8859_1"),"UTF-8");
//			 String salary = new String(request.getParameter("salary").getBytes("ISO8859_1"),"UTF-8");
//			 String date = new String(request.getParameter("date").getBytes("ISO8859_1"),"UTF-8");
//			 String language = new String(request.getParameter("language").getBytes("ISO8859_1"),"UTF-8");
//			 System.out.println("name================" + name);
//			 System.out.println("address================" + address);
//			 System.out.println("salary================" + salary);
//			 System.out.println("date================" + date);
//			 System.out.println("language================" + language);
			 sql = "insert into "+tableName+ "(job_name,date,work_address,salary,language) values(?,?,?,?,?)";
//			 System.out.println("sql="+sql);
			 commonOperationManager.executeUpdate(sql, new String[]{name,date,address,salary,language});
			System.out.println("insert success!!!");
			response.getWriter().write("success");
			response.getWriter().flush();
			response.getWriter().close();
			return;
		} else if ("delete".equals(action)) {
			System.out.println("--------------------delete------------------");
			String ids=request.getParameter("id");
//			System.out.println("ids="+ids);
			sql = "delete from "+tableName+" where id in ("+ids+")";
//			System.out.println("sql="+sql);
			commonOperationManager.executeUpdate(sql, null);
			System.out.println("delete success!!!");
			response.getWriter().write("success");
			response.getWriter().flush();
			response.getWriter().close();
			return;
		} else if ("modify".equals(action)) {
			System.out.println("--------------------modify-------------------");
			String id=request.getParameter("id");
			System.out.println("id="+id);
			String name=java.net.URLDecoder.decode(request.getParameter("name"),"UTF-8");
			 String address=java.net.URLDecoder.decode(request.getParameter("address"),"UTF-8");
			 String salary=java.net.URLDecoder.decode(request.getParameter("salary"),"UTF-8");
			 String date=java.net.URLDecoder.decode(request.getParameter("date"),"UTF-8");
			 String language=java.net.URLDecoder.decode(request.getParameter("language"),"UTF-8");
//			String name = new String(request.getParameter("name").getBytes("ISO8859_1"),"UTF-8");
//			 String address = new String(request.getParameter("address").getBytes("ISO8859_1"),"UTF-8");
//			 String salary = new String(request.getParameter("salary").getBytes("ISO8859_1"),"UTF-8");
//			 String date = new String(request.getParameter("date").getBytes("ISO8859_1"),"UTF-8");
//			 String language = new String(request.getParameter("language").getBytes("ISO8859_1"),"UTF-8");
//			 System.out.println("name================" + name);
//			 System.out.println("address================" + address);
//			 System.out.println("salary================" + salary);
//			 System.out.println("date================" + date);
//			 System.out.println("language================" + language);
			sql = "UPDATE "+tableName+" set job_name=?,work_address=?,salary=?,date=?,language=? where id = "+id;
			commonOperationManager.executeUpdate(sql, new String[]{name,address,salary,date,language});
			System.out.println("UPDATE success!!!");
			response.getWriter().write("success");
			response.getWriter().flush();
			response.getWriter().close();
			return;
		}
//		else if("modifyFromContextMenu".equals(action)){
//			System.out.println("--------------------modifyFromContextMenu-------------------");
//			String id=request.getParameter("id");
//			System.out.println("id="+id);
//			
//		}
		
		// 当前第几页
		String pageIndex = request.getParameter("page");
//		System.out.println("pageIndex=" + pageIndex);
		// 每页多少条
		String pageSize = request.getParameter("rp");
//		System.out.println("pageSize=" + pageSize);
		// 条件字段值ֵ
		String query = new String(request.getParameter("query").getBytes("ISO8859-1"), "UTF-8");
//		System.out.println("query=" + query);
		// 条件字段
		String qtype = request.getParameter("qtype");
//		System.out.println("qtype=" + qtype);
		// 排序字段
		String sortname = request.getParameter("sortname");
//		System.out.println("sortname=" + sortname);
		// desc or asc
		String sortorder = request.getParameter("sortorder");
//		System.out.println("sortorder=" + sortorder);
		//操作符
		String qop = request.getParameter("qop");
//		System.out.println("qop=" + qop);
		int count = 0;
		List list = null;
		try {
			sql = "select count(*) from " + tableName;
			if (!query.equals("")) {
				sql += " where " + qtype + " like " +"'%" + query + "%'";
			}
			//System.out.println("sql0=" + sql);
			count = commonOperationManager.executeQuery(sql);
			//System.out.println("count=" + count);
			/**mysql数据库分页查询
			sql = "select * from " + tableName;
			if (!query.equals("")) {
				sql += " where " + qtype + " like " +"'%" + query + "%'";
			}
			sql += " order by " + sortname + " " + sortorder;
			sql += " limit "
					+ ((Integer.parseInt(pageIndex) - 1) * Integer
							.parseInt(pageSize)) + "," + pageSize;
			**/
			sql = "select * from (select TOP "+Integer.parseInt(pageSize)+" * from " + tableName +" where ";
			if (!query.equals("")) {
				sql += qtype + " like " +"'%" + query + "%' and";
			}
			sql += " (ID NOT IN (SELECT TOP "+((Integer.parseInt(pageIndex) - 1) * Integer.parseInt(pageSize))+" ID FROM "+tableName+" ORDER BY ID )) ORDER BY ID) a";
			sql += " order by " + sortname + " " + sortorder;
			//sql = "SELECT TOP "+pageSize+" * FROM Users WHERE (ID NOT IN (SELECT TOP "+pageSize*(pageNow-1)+" ID FROM Users ORDER BY ID )) ORDER BY ID ";
			
			System.out.println("sql=" + sql);
			list = commonOperationManager.executeQueryList(sql);
			//System.out.println("list.size=" + list.size());
			if (list == null) {
				System.out.println("======出错啦======");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map map = new HashMap();
		map.put("page", pageIndex);
		map.put("total", count + "");
		//to JSON
		String json = toJSON(list, map);

		response.getWriter().write(json);
		response.getWriter().flush();
		response.getWriter().close();
        
	}
	
	
	
	public String execute() throws Exception {
		
		
		
        return SUCCESS;
	}
	
	
	/**
	 * 数据JSON格式化 
	 * 
	 * @param list
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String toJSON(List list, Map map) {
		List mapList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map cellMap = new HashMap();
			cellMap.put("id", ((Map) list.get(i)).get("id").toString());
			cellMap.put("cell", new Object[] { 
					//"<input type='checkbox'/>",
					((Map) list.get(i)).get("id"),
					((Map) list.get(i)).get("job_name"),
					((Map) list.get(i)).get("work_address"),
					((Map) list.get(i)).get("salary"),
					((Map) list.get(i)).get("date"),
					((Map) list.get(i)).get("language") });
			mapList.add(cellMap);
		}
		map.put("rows", mapList);
		JSONObject object = new JSONObject(map);
//		System.out.println("object="+object.toString());
		return object.toString();
	}

	String[] fields={"id","job_name","work_address","salary","date","language"};
}
