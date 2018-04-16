package xyz.sumeshmajhi.www.sakam.Cate;

import java.io.Serializable;

/**
 * Created by saGen on 14-03-2018.
 */

public class RowData implements Serializable
{

    private String main_title/*sub_title*/;


    public RowData(String main_title)
    {
        this.main_title=main_title;
      /*  this.sub_title=sub_title;*/
    }


    public String getMain_title() {
        return main_title;
    }

    public void setMain_title(String main_title) {
        this.main_title = main_title;
    }

    /*public String getSub_title() {
        return sub_title;
    }*/

    /*public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }
*/



}
