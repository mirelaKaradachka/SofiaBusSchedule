package view.backing.schedule;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import view.utils.AdfFacesUtils;

public class LineSelectionBean {
    private String vehileTypeName;
    private String lineNumber;
    
    public LineSelectionBean() {
    }

    public void setVehileTypeName(String vehileTypeName) {
        this.vehileTypeName = vehileTypeName;
    }

    public String getVehileTypeName() {
        return vehileTypeName;
    }
    
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void searchSchedule(ActionEvent actionEvent) {
        //TODO
        //check if exist vehileTypeName with lineNumber or set invalid line number
        //set to pageFlowScope
        AdfFacesUtils.setParamToPageFlowScope("vehileType", vehileTypeName);
        AdfFacesUtils.setParamToPageFlowScope("lineNumber", lineNumber);
        //tt ln
    }

    public void vehileTypeVcl(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }


}
