package com.example.lastwork.bea;

import java.util.List;

/**
 * author:${张四佟}
 * date:2019/3/2 9:29
 * description
 */
public class CarBean {


    /**
     * result : [{"commodityId":27,"commodityName":"休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg","price":139},{"commodityId":17,"commodityName":"化妆镜","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/1.jpg","price":31},{"commodityId":8,"commodityName":"Lara style蜜颊润泽腮红","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/6/1.jpg","price":19},{"commodityId":25,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg","price":158}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 27
         * commodityName : 休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋
         * count : 1
         * pic : http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg
         * price : 139
         */

        private int commodityId;
        private String commodityName;
        private int count;
        private String pic;
        private int price;
        private boolean check;

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
