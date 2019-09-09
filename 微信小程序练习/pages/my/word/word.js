const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    coname:"",
    unname:"",
  },
  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
    // todos.get().then(res => {
    //   console.log(res.data)
    // })

  },
  formName: function (e) {
    this.setData({
      coname: e.detail.value
    })
  },
  formName1: function (e) {
    this.setData({
      unname: e.detail.value
    })
  }
  ,
  onAdd: function () {
    var that = this;
    var unname = that.data.unname;
    var coname = that.data.coname;
    if (unname!="" && coname!="")
    {
      wx.cloud.init();
      //数据库授权
      const db = wx.cloud.database();
      const todos = db.collection('testWord');
      todos.add({
        data: {
          common: coname,
          undercover: unname
        },
        success(res) {
          wx.showToast({
            title: '提交成功',
            icon: 'succes',
            duration: 1000,
            mask: true
          })
        }


      })
    }
    else{
      wx.showToast({
        title: '输入不能为空',
        icon: 'none',
        duration: 1000,
        mask: true
      })
    }
    this.setData({
      coname: "",
      unname: ""
    })
    
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