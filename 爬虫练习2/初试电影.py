'''
File:初试电影.py
Project:movies
Author:王继鹏
File Created:2019/2/1
'''

import tkinter
import urllib
import time
import re
import chardet
from tkinter import scrolledtext
from urllib.request import urlretrieve

import requests
import threading
url_name = []
# a = 1 #页码
def get():
    # global a
    head = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4482.400 QQBrowser/9.7.13001.400'}
    url = 'https://www.dytt8.net/html/gndy/dyzz/index.html'
    # html = requests.get(url,headers = head).text.encode('gb2312','ignore').decode('gbk','ignore')
    html = requests.get(url,headers = head).text.encode('iso-8859-1','ignore').decode('gbk','ignore')
    # print(html)
    # varl.set("爬取到第%s页" %(a))
    url_content = re.compile(r'(<ul>.*?</ul>)',re.S)
    url_contents = re.findall(url_content,html)
    print(url_contents)
    url_all = []
    for i in url_contents:
        url_reg = re.compile(r'<a href="(/html/gndy/dyzz/.{8}?/.{5}?.html)" class="ulink">',re.S)
        url_items = re.findall(url_reg,i)
        url_all.append(url_items)
        # url_items = 'https: // www.dytt8.net' + url_items[i]

        if url_items:
            name_reg = re.compile(r'<a href="/html/gndy/dyzz/.{8}?/.{5}?.html" class="ulink">(.*?)</a>',re.S)
            name = re.findall(name_reg,i)
            for i,k in zip(url_all[7],name):
                i = 'https://www.dytt8.net' + i
                url_name.append([i,k])

                print(i,k)
    ide = 1
    while ide < 10:
        for i in url_name:
            text.insert(tkinter.END, str(ide) + '.' + i[0] + '\n' + i[1] + '\n')
            url_name.pop(0)
            ide += 1

    # print(url_all[7])
    return url_name
id = 1
def write():
    global id
    while id< 10:
        url_name = get()
        for i in url_name:
            urlretrieve(i[0],'movies\\%s.mp4' %(i[1]))#.decode('utf-8').encode('gbk')
            text.insert(tkinter.END,str(id)+'.'+i[0]+'\n'+i[1]+'\n')
            # text.insert()
            url_name.pop(0)
            id+=1
        # print(url_items,name)
        varl.set("爬取完毕")
def start():
    th = threading.Thread(target=write)
    th.start()




from tkinter import  *
root = Tk()
root.title("电影下载")
root.geometry("800x350")

text = scrolledtext.ScrolledText(root)
# text = Scrollbar(root)
# text.pack(side = RIGHT,fill = Y)
text.grid()


tf = Entry(width = 20)
tf.grid(row=0,column=1)


varl = StringVar()
lb = Label(root,font = ("微软雅黑",10),fg = "red",textvariable =  varl)
varl.set("准备就绪")
# lb.pack(side = BOTTOM)
lb.grid()

btn1 = Button(root,text ='搜索',font = ("微软雅黑",10),command = get)
btn2 = Button(root,text ='下载',font = ("微软雅黑",10),command = start)

# btn1.pack(side = LEFT)
# btn2.pack(side = LEFT)
btn1.grid(row=0,column=2)
btn2.grid(row=0,column=3)
root.mainloop()
