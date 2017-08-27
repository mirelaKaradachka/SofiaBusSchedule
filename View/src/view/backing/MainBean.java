package view.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import view.service.readers.HtmlReader;

public class MainBean {
    private RichOutputText textField;
    private String selectBusStop;

    public MainBean() {
    }

    public void helloBtn(ActionEvent actionEvent) {
        if(textField != null){
            if(textField.isVisible()){
                textField.setVisible(false);}
            else{
                textField.setVisible(true);
            }
        }
    }

    public void setTextField(RichOutputText textField) {
        this.textField = textField;
    }

    public RichOutputText getTextField() {
        return textField;
    }
    List<SelectItem> customList;

        public void setCustomList(List<SelectItem> customList) {
            this.customList = customList;
        }

        public List<SelectItem> getCustomList() {
            if (customList == null) {
                        customList = new ArrayList<SelectItem>();
                        Map<String,String> map = HtmlReader.getBusStopsAll();
                        for(Map.Entry entry : map.entrySet()){
                            customList.add(new SelectItem(entry.getKey(), (entry.getValue()!=null ? entry.getValue().toString(): null)));
                        }
                }
            return customList;
        }

    public void busListVcl(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setSelectBusStop(String selectBusStop) {
        this.selectBusStop = selectBusStop;
    }

    public String getSelectBusStop() {
        return selectBusStop;
    }
    
        /**
        * Get Current Date
        * @return
        */
    public Date getCurrentDateTime(){
      return new Date(System.currentTimeMillis());
          //new Date(new java.sql.Timestamp(System.currentTimeMillis()));
    }
}
