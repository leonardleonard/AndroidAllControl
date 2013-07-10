package lmc.entity;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
public class TreeEle {
	private String id = null;
	private String title = null;
	private boolean hasChild = false;
	private List<TreeEle>childs = null;
	private Intent it = null;
	private boolean isOpen = true;
	private int level = 0;
	/**
	 * 不可跳转有/无子节点的节点
	 * @param id:节点ID
	 * @param title:节点标题
	 * @param hasChild:是否有子节点
	 * */
	public TreeEle(String id, String title, boolean hasChild) {
		this.id = id;
		this.title = title;
		this.hasChild = hasChild;
		if(hasChild){
			this.childs = new ArrayList<TreeEle>();
		}else{
			this.childs = null;
		}
		this.it = null;
		this.isOpen = false;
	}
	/**
	 * 可跳转的叶子节点
	 * @param id:节点ID
	 * @param title:节点标题
	 * @param it:跳转路径
	 * */
	public TreeEle(String id, String title, Intent it) {
		this.id = id;
		this.title = title;
		this.hasChild = false;
		this.childs = null;
		this.it = it;
		this.isOpen = false;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public List<TreeEle> getChilds() {
		return childs;
	}
	public void addChild(TreeEle ele){
		if(hasChild){
			childs.add(ele);
		}	
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public void forward(Context con){
		if(it!=null&&con!=null){
			con.startActivity(it);
		}
	}
}