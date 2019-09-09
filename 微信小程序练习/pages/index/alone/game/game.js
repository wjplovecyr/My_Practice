const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    player:1,
    index:1,
    bg: 'frame one',//默认反面在上面
    fg: 'frame two',
    word:"",
    unvalue:1,
    wvalue:"",
    undercover:1,
    gather:[],
    rand:1,
    total:0,
  },
  restart:function(e)
  {
    wx.redirectTo({
      url: 'game',
    })

  }
  ,
  //点击产生随机底牌
  next:function(e){
    var that = this;
    var index = that.data.index;
    var player = that.data.player;
    var gather = that.data.gather;
    var rand = that.data.rand;
    var undercover = that.data.undercover;
    if(player<index)
    { 
      this.setData
      ({
        player: player+1,
        bg: "frame one",
        fg: "frame two",
      })
 //更改词语
    
      console.log(rand)
      if (app.globalData.temp == true)
      {
        if (player + 1 == rand) {
          this.setData({
            word: "",
          });
        }
        else {
          this.setData({
            word: gather.common,
          });
        }
      }
      else
      {
        if (player + 1 == rand) {
          this.setData({
            word: gather.undercover,
          });
        }
        else {
          this.setData({
            word: gather.common,
          });
        }
      }

      
    }
    else
    {
      wx.navigateTo({
        url: 'undercover/undercover',
      })
    }

    
    
  },
  bat: function (e) {
    var that = this
    if (this.data.bg == 'frame one' &&
      this.data.fg == 'frame two') {
      that.setData({
        bg: "frame front",
        fg: "frame back",
      })
      setTimeout(function () {
        that.setData({
          bg: "frame two",
          fg: "frame one",
        })
      }, 1000);
    }
    else {
      that.setData({
        bg: "frame back",
        fg: "frame front",
      })
      setTimeout(function () {
        that.setData({
          bg: "frame one",
          fg: "frame two",
        })
      }, 1000);

    }
    
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    app.globalData.back = false;

    wx.cloud.init();
    var that = this;
    var rand = that.data.rand;
    // var index = options.index;//获取值
    var index = app.globalData.index;
    var undercover = that.data.undercover;
    var player = that.data.player;
    // that.data.index = index;
    this.setData({
      index:index,
    });
    //由于需要同步获取数据，可能较慢，最好加入加载动画​ 
    wx.showLoading
    ({ 
      title: '加载中', 
    })
  
    //数据库授权
    const db = wx.cloud.database();
    const todos = db.collection('Word');
    //定义每次获取的条数​ 
    const MAX_LIMIT = 20;
     //先取出集合的总数 
    const countResult =  todos.count() 
    console.log(countResult)
    
    
    // console.log(total)
    todos.count({
      success: function (res) {
        var that = this;
        // var total = that.data.total;
        var total;
        console.log(res.total);
        total = res.total;
        this.setData({
          total: total,
        });
      }
    })
    var that = this;
    var total = that.data.total;
    console.log(total)


     //计算需分几次取 
    const batchTimes = Math.ceil(total / MAX_LIMIT) 
     // 承载所有读操作的 promise  的数组
    const gatherplus = []
    
    // // //把数据传递至页面视图 
    
    //数据库查询
    todos.get().then(res => {
      var gather = that.data.gather;
      //初次循环获取云端数据库的分次数的promise 数组
      for (let i = 0; i < batchTimes; i++) {
       
        const promise =  todos.skip(i * MAX_LIMIT).limit(MAX_LIMIT).get()
        // console.log(promise)
        //二次循环根据​获取的promise 数组的数据长度获取全部数据push到gatherplus数组中
        for (let j = 0; j < promise.data.length; j++) {
          gatherplus.push(promise.data[j])
        }
      }
     
      that.setData
      ({ 
          gather: gatherplus, 
      })
      // gather = res.data;
      wx.hideLoading();


      // console.log(gather);

      var n = Math.round(Math.random() * (gather.length - 1));
      rand = Math.ceil(Math.random() * (index));
      app.globalData.rand = rand;//将随机数加入全局变量

      this.setData({
        rand:rand,
        gather:gather[n],
      })
      // console.log(app.globalData.temp);
      if (app.globalData.temp==true)
      {
        if (player == rand) {
          this.setData({
            word: "",
          });
        }
        else {
          this.setData({
            word: gather[n].common,

          });
        }
      }
      else
      {
        if (player == rand) {
          this.setData({
            word: gather[n].undercover,


          });
        }
        else {
          this.setData({
            word: gather[n].common,

          });
        }
      }
      


    })
    
  },

  // onAdd:function(){
  //   todos.add({
  //     data: {
  //       common: "煎饼果子",
  //       undercover: "手抓饼"
  //     },
      // success(res) {
      //   // res.data 包含该记录的数据
      //   // console.log(res.data)
      //   console.log(res)
      // }
  // })
  // },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if(app.globalData.back)
    {
      wx.redirectTo({
        url: 'game',
      })
    }
   
  

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