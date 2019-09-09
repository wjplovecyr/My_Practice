import tkinter

import requests
import os
from you_get import common



class GetMovies:
    def __init__(self,url, root):
        head = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4482.400 QQBrowser/9.7.13001.400'}
        self.url = url
        self.root = root
        self.path = root + url.split('/')[-1]

    def getmove(self):     #文件存放路径，文件名
        try:
            if not os.path.exists(self.root):
                os.mkdir(self.root)
            if not os.path.exists(self.path):
                # text1.insert(tkinter.END, "下载中，请稍后")
                os.system('you-get -o'+' '+self.root+' '+self.url)
                print("文件成功保存")

            else:
                print("文件已存在")
                # text1.insert(tkinter.END, "文件已存在")
        except:
            print("产生异常")
            # text1.insert(tkinter.END, "文件下载失败")

# a = GetMovies("http://www.iqiyi.com/v_19rqu7afxk.html","D://小电影测试//")
# a.get()
# import subprocess
# import sys
#
# def RunShellWithReturnCode(command,print_output=True,universal_newlines=True):
#     p = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE, shell=True, universal_newlines=universal_newlines)
#     if print_output:
#         output_array = []
#         while True:
#             line = p.stdout.readline()
#             if not line:
#                 break
#             print(line.strip("/n"))
#             output_array.append(line)
#         output ="".join(output_array)
#     else:
#         output = p.stdout.read()
#     p.wait()
#     errout = p.stderr.read()
#     if print_output and errout:
#         print >> sys.stderr, errout
#     p.stdout.close()
#     p.stderr.close()
#     return output, p.returncode
# f=RunShellWithReturnCode()
# "https://www.bilibili.com/video/av47730455?from=search&seid=17507581597340804922"
# "D://小电影测试//"
# common.any_download(url='一个优酷地址',stream_id='mp4',info_only=False,output_dir=r'保存的目录',merge=True)