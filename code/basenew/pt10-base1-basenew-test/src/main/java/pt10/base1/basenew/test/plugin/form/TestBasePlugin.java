package pt10.base1.basenew.test.plugin.form;

import kd.bos.base.AbstractBasePlugIn;
import kd.bos.dataentity.entity.DynamicObject;
import kd.sdk.plugin.Plugin;

import java.util.EventObject;

/**
 * 基础资料插件
 */
public class TestBasePlugin extends AbstractBasePlugIn implements Plugin {
    @Override
    public void afterCreateNewData(EventObject e) {
        super.afterCreateNewData(e);
        Object org = getModel().getValue("createorg");
        if(org != null){
            this.getView().showMessage(((DynamicObject)org).getString("name"));
        }

    }
}