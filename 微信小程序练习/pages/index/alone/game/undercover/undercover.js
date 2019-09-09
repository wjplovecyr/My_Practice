const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    index:"",
    rand: app.globalData.rand,
    key:"",
    temp:true,
    dates:[
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
      { "temp": true, "state": 0 },
    ]

  },
  continue: function(e){
    // var that = this;
    // var rand = that.data.rand;
    app.globalData.back = true;
    wx.navigateBack({
      url: 'game/game',
    })
  }
  ,
  change: function (e) {

    // var index=parseInt(e.currentTarget.dataset.idx);
    var index = e.currentTarget.dataset.index;
    // index=index+1
    console.log(index)
    // if (this.data.dates[index].state == 1) {
    //   this.data.dates[index].state = 0;
    // }
    // else 

    if (this.data.dates[index].state == 0) 
    {
      this.data.dates[index].temp = false;
      this.data.dates[index].state = 1;
    }
    // if (this.data.dates[rand].state == 1)
    // {

    // }

    this.setData({
      // hiddenName: false,
      dates: this.data.dates,
    })


  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    this.setData({
      index: app.globalData.index,
      rand:app.globalData.rand,
    });
    // console.log(app.globalData.index)
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