import tkinter
import urllib
import time
import re
from tkinter import scrolledtext
from urllib.request import urlretrieve

import requests
import threading
url_name = []
a = 1 #页码
def get():
    global a
    head = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4482.400 QQBrowser/9.7.13001.400'}
    url = 'http://www.budejie.com/video/'+str(a)
    html = requests.get(url,headers = head).text  #.encode('utf-8')
    # print(html)
    varl.set("爬取到第%s页" %(a))
    url_content = re.compile(r'(<div class="j-r-list-c">.*?</div>.*?</div>)',re.S)
    url_contents = re.findall(url_content,html)
    print(url_contents)
    for i in url_contents:
        url_reg = r'data-mp4="(.*?)"'
        url_items = re.findall(url_reg,i)
        if url_items:
            name_reg = re.compile(r'<a href="/detail-.{8}?.html">(.*?)</a>',re.S)
            name = re.findall(name_reg,i)
            for i,k in zip(url_items,name):
                url_name.append([i,k])
            # print(i,k)
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
root.title("我的第一个python窗口")
root.geometry("500x400")

text = scrolledtext.ScrolledText(root)
# text = Scrollbar(root)
# text.pack(side = RIGHT,fill = Y)
text.grid()
varl = StringVar()

lb = Label(root,font = ("微软雅黑",10),fg = "red",textvariable =  varl)
varl.set("准备就绪")
# lb.pack(side = BOTTOM)
lb.grid()
btn = Button(root,text ='开始爬取',font = ("微软雅黑",10),command = start)
# btn.pack(side = BOTTOM)
btn.grid()
root.mainloop()
