package com.example.firstweekexercises.bean;

import java.util.List;

/**
 * author:${张四佟}
 * date:2019/2/16 8:59
 * description
 */
public class SousBean {

    /**
     * result : [{"commodityId":150,"commodityName":"秋季真皮系带男款婚鞋尖头英伦男士正装商务鞋男鞋男士皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/2/1.jpg","price":328,"saleNum":0},{"commodityId":158,"commodityName":"系带商务鞋休闲鞋皮鞋棉鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/swxxx/3/1.jpg","price":99,"saleNum":0},{"commodityId":166,"commodityName":"耐磨减震 男款篮球鞋 乔丹","masterPic":"http://172.17.8.100/images/small/commodity/nx/ydx/4/1.jpg","price":189,"saleNum":0},{"commodityId":142,"commodityName":"秋季爆款高帮帆布鞋 街头防滑双色阴阳鞋 男士高帮帆布鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/1/1.jpg","price":109,"saleNum":0},{"commodityId":155,"commodityName":"AUXTUN男鞋韩版商务典雅尖头男士皮鞋潮流英伦系带正装休闲皮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/px/7/1.jpg","price":129,"saleNum":0}]
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
         * commodityId : 150
         * commodityName : 秋季真皮系带男款婚鞋尖头英伦男士正装商务鞋男鞋男士皮鞋
         * masterPic : http://172.17.8.100/images/small/commodity/nx/px/2/1.jpg
         * price : 328
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

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

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
