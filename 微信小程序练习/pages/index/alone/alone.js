const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    array: [3,4,5,6,7,8,9,10],
    objectArray: [
      {
        id: 3,
        name: 'three'
      },
      {
        id: 4,
        name: 'four'
      },
      {
        id: 5,
        name: 'five'
      },
      {
        id: 6,
        name: 'six'
      }, {
        id: 7,
        name: 'seven'
      },
      {
        id: 8,
        name: 'eight'
      },
      {
        id: 9,
        name: 'nine'
      }, 
      {
        id: 10,
        name: 'ten'
      }
    ],
    index: 0,
    temp:true,
    // temp1:false,
    // unvalue:1,
    // focus:false,
    // wvalue:"",
  
  },
  
  // unnumber:function(e){
  //   var that = this;
  //   var array = that.data.array;
  //   var index = that.data.index;

  //   if(e.detail.value>=array[index]/2)
  //   {
  //     this.setData({
  //       unvalue: parseInt(array[index]/2)
        
  //     })
  //   }
  // },
  // wnumber: function (e) {
  //   var that = this;
  //   var array = that.data.array;
  //   var index = that.data.index;
    
  //   if (e.detail.value >= array[index] / 2) {
  //     this.setData({
  //       wvalue: parseInt(array[index] / 2)
  //     })
  //   }
  // },
  bindPickerChange: function (e) {
    this.setData({
      index: e.detail.value
    })
  },
  switchChange(e) {        //判断是否选中白板btn
    if(e.detail.value){
      var that = this;
      app.globalData.temp = true;

    }
    else {
      app.globalData.temp = false;
    }
  },
  game:function(e){
    var that = this;
    var index = that.data.index;

    app.globalData.index = parseInt(index) + parseInt(3);
    wx.navigateTo({
      url: "game/game"

    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  }
})
