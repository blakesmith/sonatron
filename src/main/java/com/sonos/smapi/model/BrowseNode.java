// package com.sonos.smapi.model;

// import java.lang.reflect.InvocationTargetException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Locale;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

// import com.sonos.services._1.AbstractMedia;
// import com.sonos.services._1.ItemType;
// import com.sonos.services._1.MediaCollection;
// import com.sonos.services._1.MediaList;
// import com.sonos.services._1_1.SonosSoap;
// import com.sonos.smapi.service.impl.ReferenceService;

// /**
//  * The browse node is used to set up the containers for music browsing for the music service
//  * @author keith.corbin
//  *
//  */
// public class BrowseNode {
// 	private static Logger logger = LoggerFactory.getLogger(BrowseNode.class);
	
// 	ApplicationContext context = new ClassPathXmlApplicationContext("locale.xml");
// 	/**
// 	 * The parent node of the current node
// 	 */
// 	private BrowseNode parent;
	
// 	/**
// 	 *  The String id of the node.  This is what is passed into getMetadata()
// 	 */
// 	private String id;
	
// 	/**
// 	 *  The title of the container to display in the UI
// 	 */
// 	private String title;
	
// 	/**
// 	 * The type of node
// 	 */
// 	private ItemType itemType;
	
// 	/**
// 	 * The list of child nodes
// 	 */
// 	private List<BrowseNode> children = new ArrayList<BrowseNode>();
	
// 	/**
// 	 * The method to use to populate the node.  This method must exist in the service implementation.  
// 	 * That is, it must be a public method that exists in the implementation on the SonosSoap interface.
// 	 * All methods must have the signature method(String id, int index, int count, String sessionId)
// 	 */
// 	private String serviceMethodToCall;
	
// 	/**
// 	 * A static list of all BrowseNode instances.
// 	 */
// 	public static HashMap<String, BrowseNode> instanceList = new HashMap<String, BrowseNode>();

// 	/**
// 	 * Browse node constructor
// 	 * @param id The id of the node, this is what is passed into getMetadata
// 	 * @param title The display name of the noded
// 	 * @param itemType The type of node.
// 	 * @param serviceMethodToCall  The method to call to populate the node.
// 	 */
// 	public BrowseNode(String id,
// 			String title, ItemType itemType, String serviceMethodToCall) {
// 		this.id = id;
// 		this.title = title;
// 		this.itemType = itemType;
// 		this.serviceMethodToCall = serviceMethodToCall;
// 	}

// 	/**
// 	 * Populate this method is called to populate a node.  This method in turn calls the service method defined on the node
// 	 * @param id
// 	 * @param index
// 	 * @param count
// 	 * @param sessionId The session id of the user making the request.
// 	 * @param service The service being used for the call.  This is what the serviceMethodTocall method is called on.
// 	 * @return
// 	 */
// 	public MediaList populate (String id, int index, int count, String sessionId, SonosSoap  service, String language){
// 		if (this.serviceMethodToCall.equals(ReferenceService.GET_CHILDREN)){
// 			MediaList mediaList = new MediaList();
// 			List<BrowseNode> childNodes = this.getChildren();
// 			List<AbstractMedia> mcList = mediaList.getMediaCollectionOrMediaMetadata();
// 			mediaList.setCount(childNodes.size());
// 			mediaList.setIndex(index);
// 			mediaList.setTotal(childNodes.size());
// 			for (BrowseNode bn : childNodes){
// 				MediaCollection mc = new MediaCollection();
// 				mc.setTitle(getLocalizedString(bn.getTitle(), language));
// 				mc.setId(bn.getId());
// 				mc.setItemType(bn.getItemType());
// 				mc.setCanPlay(true);
// 				mcList.add(mc);
// 			}
// 			return mediaList;
// 		} else {
// 			java.lang.reflect.Method method;
// 			try {
			
// 			  method = service.getClass().getMethod(serviceMethodToCall, String.class, int.class, int.class, String.class);
// 			  return (MediaList)method.invoke(service, id, index, count, sessionId);
			  
// 			} catch (SecurityException e) {
// 			  logger.error("Security exception", e);
// 			} catch (NoSuchMethodException e) {
// 			  logger.error("The method "+serviceMethodToCall+" is not defined in "+service.getClass().getName());
// 			} catch (IllegalArgumentException e) {
// 			  logger.error("IllegalArgumentException ", e);
// 			} catch (IllegalAccessException e) {
// 			  logger.error("IllegalAccessException ", e);
// 			} catch (InvocationTargetException e) {
// 			  logger.error("InvocationTargetException ", e);
// 			}
// 		}
// 		//this will only be reached if we get an exception in invoking the method call.
// 		return null;
// 	}
	
	
// 	/**
// 	 * This method takes a string token and localizes it for the 
// 	 * @param id
// 	 * @param language
// 	 * @return
// 	 */
// 	public String getLocalizedString(String id, String language){
// 		logger.debug("Get localized string called for: "+id+" for language: "+language);
// 		Locale locale = new Locale(language);
// 		return context.getMessage(id,new Object[]{}, locale);
// 	}
	
// 	/**
// 	 * @return The parent Node
// 	 */
// 	public BrowseNode getParent() {
// 		return parent;
// 	}

// 	/**
// 	 * @return THe node id
// 	 */
// 	public String getId() {
// 		return id;
// 	}

// 	/**
// 	 * @param id
// 	 */
// 	public void setId(String id) {
// 		this.id = id;
// 	}

// 	/**
// 	 * @return the node title
// 	 */
// 	public String getTitle() {
// 		return title;
// 	}

// 	/**
// 	 * @param title
// 	 */
// 	public void setTitle(String title) {
// 		this.title = title;
// 	}

// 	/**
// 	 * @return the node type
// 	 */
// 	public ItemType getItemType() {
// 		return itemType;
// 	}

// 	/**
// 	 * @param itemType
// 	 */
// 	public void setItemType(ItemType itemType) {
// 		this.itemType = itemType;
// 	}

// 	/**
// 	 * @return the nodes children
// 	 */
// 	public List<BrowseNode> getChildren() {
// 		return children;
// 	}

// 	/**
// 	 * @param children
// 	 */
// 	public void setChildren(List<BrowseNode> children) {
// 		this.children = children;
// 	}

// 	/**
// 	 * @param parent
// 	 */
// 	public void setParent(BrowseNode parent) {
// 		this.parent = parent;
// 	}

// 	/**
// 	 * @return a list of all node instances
// 	 */
// 	public static HashMap<String, BrowseNode> getInstanceList() {
// 		return instanceList;
// 	}

// 	/**
// 	 * @param instanceList
// 	 */
// 	public static void setInstanceList(HashMap<String, BrowseNode> instanceList) {
// 		BrowseNode.instanceList = instanceList;
// 	}

// 	/**
// 	 * Add a new node.
// 	 * @param idParent
// 	 * @param node
// 	 */
// 	public static void add(String idParent, BrowseNode node) {
// 		BrowseNode parent;
// 		if (idParent != null || !"".equals(idParent)) {
// 			parent = instanceList.get(idParent);
// 		} else {
// 			parent = null;
// 		}
// 		node.parent = parent;
// 		instanceList.put(node.getId(), node);
// 		if (node.parent!=null){
// 			node.parent.getChildren().add(node);
// 		}
// 	}

// }
