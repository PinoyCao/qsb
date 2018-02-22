package com.ccniit.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class Menu {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer parentId;
	@JsonIgnore
	private Menu parent;	//就是上面的parentId
	private String parentIds; // 所有父级编号
	private String name; 	// 名称
	private String href; 	// 链接
	private String icon; 	// 图标
	private String isShow; 	// 是否在菜单中显示（1：显示；0：不显示）
	private String permission; // 权限标识
	private String html;
	public Menu() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@JsonIgnore
	public static String getRootId(){
		return "1";
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
}
