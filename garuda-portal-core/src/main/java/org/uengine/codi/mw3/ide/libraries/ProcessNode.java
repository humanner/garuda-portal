package org.uengine.codi.mw3.ide.libraries;

import org.metaworks.MetaworksContext;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToOpener;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.codi.mw3.ide.ResourceNode;
import org.uengine.codi.mw3.model.Popup;

/* child 를 나타내는 폴더형식으로 하려면 아래 주석을 풀어서 ejs를 입혀주세요 - 14.02.11 김형국
@Face(
		ejsPath = "dwr/metaworks/org/uengine/codi/mw3/ide/libraries/ProcessNode.ejs",
		ejsPathMappingByContext = {
				"{how:	'tree', face: 'dwr/metaworks/org/uengine/codi/mw3/ide/libraries/ProcessNode.ejs'}",
				"{how:	'resourcePicker', face: 'dwr/metaworks/org/metaworks/metadata/ResourceNodePicker.ejs'}"
		})
*/
public class ProcessNode extends ResourceNode{
	
	String parentName;
		public String getParentName() {
			return parentName;
		}
		public void setParentName(String parentName) {
			this.parentName = parentName;
		}
	String path;
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
	ActivityNode activityNode;
		public ActivityNode getActivityNode() {
			return activityNode;
		}
		public void setActivityNode(ActivityNode activityNode) {
			this.activityNode = activityNode;
		}
	RoleNode roleNode;
		public RoleNode getRoleNode() {
			return roleNode;
		}
		public void setRoleNode(RoleNode roleNode) {
			this.roleNode = roleNode;
		}
	String projectId;
		public String getProjectId() {
			return projectId;
		}
		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}
	MetaworksContext metaworksContext;
		public MetaworksContext getMetaworksContext() {
			return metaworksContext;
		}
		public void setMetaworksContext(MetaworksContext metaworksContext) {
			this.metaworksContext = metaworksContext;
		}
		
	@Override
	@ServiceMethod(callByContent=true, except="child", mouseBinding="right", target=ServiceMethodContext.TARGET_POPUP)
	public Object[] showContextMenu() {
		session.setClipboard(this);
//		return new Object[]{new ResourceContextMenu(this, session) , new Refresh(session)};
		return null;
	}
		
	@Override
	@ServiceMethod(callByContent=true, except="child", target=ServiceMethodContext.TARGET_APPEND)
	public Object action(){

		if(this.getMetaworksContext() != null && "resource".equals(this.getMetaworksContext().getWhere())){
			metadataProperty.setResourceNode(this);

			//픽업되는 순간  xml에 저장하고 load 해서 미리보기 
			this.getMetaworksContext().setHow("resourcePicker");
			this.getMetaworksContext().setWhen(MetaworksContext.WHEN_VIEW);
			
			return new Object[]{new ToOpener(this), new Remover(new Popup())};	
		}else{
			ProcessNode processNode = new ProcessNode();
			processNode.setId(this.getId());
			processNode.setName(this.getName());
			processNode.setType(this.getType());
			processNode.setPath(this.getPath());
			processNode.setProjectId(this.getProjectId());
			
//			Editor editor = new ProcessEditor(this);
//			try {
//				editor.load();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			InstanceViewThreadPanel instanceViewThreadPanel = new InstanceViewThreadPanel();
//			if( ((ProcessEditor)editor).getProcessDesignerInstanceId() != null ){
//				instanceViewThreadPanel.session = session;
//				instanceViewThreadPanel.setInstanceId(((ProcessEditor)editor).getProcessDesignerInstanceId());
//				instanceViewThreadPanel.load();
//			}
//			CloudInstanceWindow cloudInstanceWindow = new CloudInstanceWindow();
//			cloudInstanceWindow.setPanel(instanceViewThreadPanel);
			
//			return new Object[]{new ToAppend(new CloudWindow("editor"), editor) };
//			return new Object[]{new ToAppend(new CloudWindow("editor"), editor) , new Refresh(cloudInstanceWindow, true) };
			return null;
		}
	}		
	
	@Override
	@ServiceMethod(callByContent=true, except="child", target=ServiceMethodContext.TARGET_SELF)
	public Object expand() throws Exception{
		/* child 를 나타내는 폴더형식으로 하려면 아래 주석을 풀어서 엑션을 입혀주세요 - 14.02.11 김형국
		ProcessDesignerContentPanel processDesignerContentPanel = new ProcessDesignerContentPanel();
		processDesignerContentPanel.setAlias(this.getPath());
		processDesignerContentPanel.setBasePath("");
		processDesignerContentPanel.load();
		
		ProcessDesignerContainer container = processDesignerContentPanel.getProcessDesignerContainer();
		ArrayList<Activity> activityList = container.getActivityList();
		for(int aCount = 0; aCount < activityList.size(); aCount++) {
			ActivityNode activityNode = new ActivityNode();
			Activity activity = activityList.get(aCount);
			String name = "";
			if( activity.getName() != null && activity.getName().getText() != null){
				name = activity.getName().getText();
			}else{
				name = activity.getClass().getName() + activity.getTracingTag();
			}
			activity.setActivityView(null);
			activityNode.setActivity(activity);
			activityNode.setId("activity_" + activity.getTracingTag());
			activityNode.setName(name);
			activityNode.setPath(this.getPath());
			activityNode.setParentId(this.getId());
			activityNode.setType(ResourceNode.TYPE_ACTIVITY);
			this.setActivityNode(activityNode);
			this.add(activityNode);
		}
		ArrayList<Role> roleList = container.getRolePanel().getRoleList();
		for(int rCount = 0; rCount < roleList.size(); rCount++) {
			RoleNode roleNode = new RoleNode();
			Role role = roleList.get(rCount);
			String name = "";
			if( role.getName() != null ){
				name = role.getName();
			}else{
				name = role.getClass().getName() + role.getDisplayName();
			}
			role.setRoleView(null);
			roleNode.setRole(role);
			roleNode.setId("role_" + role.getDisplayName());
			roleNode.setName(name);
			roleNode.setPath(this.getPath());
			roleNode.setParentId(this.getId());
			roleNode.setType(ResourceNode.TYPE_ROLE);
			this.setRoleNode(roleNode);
			this.add(roleNode);
			
		}
		
		return this;
		*/
		return null;
	}
	
}
