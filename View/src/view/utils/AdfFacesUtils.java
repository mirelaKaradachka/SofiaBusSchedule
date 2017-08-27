package view.utils;

import java.util.Map;

import oracle.adf.share.ADFContext;

public final class AdfFacesUtils {
    private static Map pageFlowScope;

    private AdfFacesUtils() {
        super();
    }
    
    private static Map getPageFlowScope() {
        Map newPageFlowScope = null;
        if(pageFlowScope == null){
            ADFContext adfCtx = ADFContext.getCurrent();
            //AdfFacesContext context= AdfFacesContext.getCurrentInstance();
            pageFlowScope = adfCtx.getPageFlowScope();
        }
        return pageFlowScope;
    }
    
    public static void setParamToPageFlowScope(String paramName, Object paramValue){
        if(paramName!=null){
            getPageFlowScope().put(paramName, paramValue);
        }
    }
    
    public static Object getParamToPageFlowScope(String paramName){
        Object value = null;
        if(paramName!=null){//check if needed (call pageFlowScope.get(null);)
            value = getPageFlowScope().get(paramName);
            //TODO Remove later - debuging
            System.out.println(value.toString());   
        }
        return value;
    }
}
