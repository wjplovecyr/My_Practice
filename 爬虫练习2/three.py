#import urllib
import os
import re
import requests


#reload(sys)
#sys.setdefaultencoding("utf-8")


#a = 1
import urllib

url_name = [];
def get(pageindex):
    ###  url : 想要爬取的网站 str(pageindex)：爬取网站的页码
    url = 'http://www.budejie.com/video/' + str(pageindex);
    #var1.set('已经获取到第%s页的视频视频'%(a))
    print (url);




    ### 设置网站访问的请求头信息
    #有些网页，比如登录的。如果你不是从浏览器发起的起求，这就不会给你响应，
    #这时我们就需要自己来写报头。
    #然后再发给网页的服务器，这时它就以为你就是一个正常的浏览器。
    #从而就可以爬了！
    headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0'}
    req =requests.get(url, headers=headers)
    #print(req)


    #with 语句适用于对资源进行访问的场合，确保不管使用过程中是否发生异常都会执行必要的“清理”操作，
    #释放资源，比如文件使用后自动关闭、线程中锁的自动获取和释放等。
    with open('imgs/') as ss:
        # read（）设置读取文件的大小 如果不写 默认为从文件指针位置到文件结尾
        # 这里设置为30000 为读取文件的大小
      html=  ss.read(30000);




    # 设置从页面中获取的视频的连接的正则表达式
    url_reg = rb'data-mp4="(.*?)"';
    # 通过正则表达式从网页中获得视频链接
    url_items = re.findall(url_reg, html);
    #print(url_items)

    name_reg = re.compile(rb'<div class="j-r-list-c-desc".*?<a href=".*?>(.*?)</a>.*?</div>', re.S);
# 锁定视频所在的div
    name_items = re.findall(name_reg, html);
    print(name_items)
    for i, k in zip(name_items, url_items):

        url_name.append([i, k]);



#传入文件名和video地址
def saveVideo(filename,videoUrl):
    print('ssssss=',str(filename));
    print ('Saving : %s ...'%filename);
    urllib.request.urlretrieve(videoUrl.decode('utf-8'),'D:\\video\\'+str(filename)+'.mp4');
####main exec ####
for pageindex in range(1,3):
    get(pageindex);




for index,item in enumerate(url_name):


    saveVideo(index,item[1])