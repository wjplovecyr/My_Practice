'''
File:电影下载.py
Project:movies
Author:王继鹏
File Created:2019/4/10
'''
import threading
import tkinter

from tkinter import scrolledtext, ttk

from tkinter import  *
from tkinter.filedialog import askdirectory
from tkinter import END
import choose as choose

# from 爬虫获取网页视频名称 import fillUnivList
from 小电影测试代码 import GetMovies
from 爬虫获取网页视频名称 import findMove

root = Tk()
root.iconbitmap('imgs/bitbug_favicon.ico')
root.title("简易视频下载器")
root.geometry("1000x500")



#显示网页文本框
# 本网页显示当前页面的视频名称及连接
text = scrolledtext.ScrolledText(root, width=60, height=22)
text.place(relx = 0.05,rely = 0.25)

#显示视频进度是否完成
# global text1
text1 = scrolledtext.ScrolledText(root, width=50, height=12)
text1.place(relx = 0.6,rely = 0.5)




#输入框集
#主地址输入框
def change(a):
    tf_.set(a)
tf_ = StringVar()
tf = Entry(width = 30,textvariable = tf_)
tf.place(relx = 0.33,rely = 0.01)
#搜索框
find = Entry(width = 30)
find.place(relx = 0.12,rely = 0.16)
#视频地址框
find2 = Entry(width = 26)
find2.place(relx = 0.7,rely = 0.3)


#浏览本地
def selectPath():
    path_ = askdirectory()
    path.set(path_)
path = StringVar()
path.set("请输入您要保存的地址")
locallb  = Label(root,text = "请选择保存位置:").place(relx = 0.6,rely = 0.4)
localtxt = Entry(root,fg = "gray" ,textvariable = path ,width = 20)
localtxt.place(relx = 0.7,rely = 0.4)
localbtn = Button(root, text = ". . .",font = ("微软雅黑",8), width=4, command = selectPath).place(relx = 0.85,rely = 0.39)


#标签集
#大标签
lb1 = Label(root,font = ("微软雅黑",20),text = "欢迎使用",fg = "red")
lb1.place(relx = 0.86,rely = 0.02)
#下拉菜单提示框
lb2 = Label(root,font = ("微软雅黑",11),fg = "gray",text="请输入一个正规的视频网站作为本次运行的基站")
lb2.place(relx = 0,rely = 0)
#网址搜索框
lb3 = Label(root,font = ("微软雅黑",10),text = "当前网址搜索栏:")
lb3.place(relx = 0,rely = 0.15)
#视频网址
lb4 = Label(root,font = ("微软雅黑",10),text = "请输入视频网址:")
lb4.place(relx = 0.6,rely = 0.3)



#按钮集
#网址搜索栏搜索按钮

def findmove():
    keys = key + find.get()
    html = findMove(keys).find()
    text.delete(1.0,tkinter.END)
    # print(type(html))
    for i in findMove(keys).fillUnivList(html):
        # print(i[0],i[1])
        text.insert(tkinter.END,i[0]+"\n"+i[1]+"\n")
    print("查找完成")




btn1 = Button(root,text ='搜索',width = 5,font = ("微软雅黑",8),command = findmove)#,command = start
btn1.place(relx = 0.34,rely = 0.155)
#进入网址按钮



def index():
    url = tf.get()
    html = findMove(url).find()
    text.delete(1.0,tkinter.END)
    text.insert(tkinter.END, html)
    # print("查找完成")

btn2 = Button(root,text ='进入网址',font = ("微软雅黑",10),command = index )#
btn2.place(relx = 0.72,rely = 0.01)
# #视频搜索按钮
# btn3 = Button(root,text ='搜索',width = 5,font = ("微软雅黑",8))
# btn3.place(relx = 0.9,rely = 0.29)
#下载按钮
def download():
    text1.insert(tkinter.END, "正在下载......\n")
    url = find2.get()
    root = localtxt.get()
    # text.delete(1.0, tkinter.END)
    GetMovies(url,root).getmove()
    text1.insert(tkinter.END, "下载完成\n")
    # text1.delete(1.0,tkinter.END)
    # text1.insert(tkinter.END, html)
    # print("查找完成")
#创建多线程
def start():
    th = threading.Thread(target=download)
    th.start()


btn4 = Button(root,text ='下载',width = 5,font = ("微软雅黑",8),command = start )
btn4.place(relx = 0.9,rely = 0.39)


#上一页
def last():
    global pag
    if pag != 1:
        pag-=1
    keys = key + find.get()+'&page='+ str(pag)
    html = findMove(keys).find()
    text.delete(1.0, tkinter.END)
    for i in findMove(keys).fillUnivList(html):
        text.insert(tkinter.END,i[0]+"\n"+i[1]+"\n")

btn5 = Button(root,text ='上一页',width = 5,font = ("微软雅黑",8),command = last)
btn5.place(relx = 0.37,rely = 0.85)
#下一页


def next():
    # print(key)
    global pag
    pag += 1
    keys = key + find.get()+'&page='+ str(pag)
    # print(keys)
    html = findMove(keys).find()
    text.delete(1.0, tkinter.END)
    for i in findMove(keys).fillUnivList(html):
        text.insert(tkinter.END,i[0]+"\n"+i[1]+"\n")
btn6 = Button(root,text ='下一页',width = 5,font = ("微软雅黑",8),command = next)
btn6.place(relx = 0.42,rely = 0.85)


def choose(*args):
    global pag
    pag = 1
    global key
    key = ""
    if(comboxlist.get()== "哔哩哔哩"): #选中的值
        change("https://www.bilibili.com/")
        key = "https://search.bilibili.com/all?keyword="
    elif(comboxlist.get()== "腾讯视频"):
        change("https://v.qq.com/")
        key = "https://v.qq.com/x/search/?q="
    elif(comboxlist.get()== "爱奇艺"):
        change("https://www.iqiyi.com/")
        key = "https://so.iqiyi.com/so/q_"
    elif (comboxlist.get() == "优酷"):
        change("https://www.youku.com/")
        key = "https://so.youku.com/search_video/q_"

#下拉菜单
comvalue = StringVar()#窗体自带的文本，新建一个值
comvalue.set("推荐网址")
comboxlist=ttk.Combobox(root,textvariable=comvalue) #初始化
comboxlist["values"]=("哔哩哔哩","腾讯视频","爱奇艺","优酷")
# comboxlist.current("0")  #选择第一个
comboxlist.place(relx = 0.55,rely = 0.01)
comboxlist.bind("<<ComboboxSelected>>",choose)  #绑定事件,(下拉列表框被选中时，绑定go()函数)#ComboboxSelected Button-1




# path = tkinter.filedialog.askopenfilename()#从路径选择对话框中选择要打开的文件位置
# path = tkinter.filedialog.asksaveasfilename()#从文件路径对话框中选择要保存的位置


# def start():
#     th = threading.Thread(target=)
#     th.start()

# work = GetMovies()
root.mainloop()