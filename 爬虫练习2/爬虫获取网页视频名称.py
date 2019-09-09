import re
from urllib.request import urlretrieve

import bs4
import requests
from bs4 import BeautifulSoup


class findMove:
    def __init__(self,url):
        self.url = url
    def find(self):
        try:
            head = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4482.400 QQBrowser/9.7.13001.400'}
            html = requests.get(self.url, headers=head) #请求网页
            html.encoding = html.apparent_encoding      #解析网页编码
            html = html.text
            return html

        except:
            print("有错误")
    def SE(self, key):
        try:
            head = {
                'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4482.400 QQBrowser/9.7.13001.400'}
            html = requests.get(key, headers=head)  # 请求网页
            html.encoding = html.apparent_encoding  # 解析网页编码
            html = html.text
            return html

        except:
            print("有错误")

    def fillUnivList(self,html):
        url_src = []
        url_name = []
        url_all = []
        soup = BeautifulSoup(html, "html.parser")
        for li in soup.find('ul', class_="video-contain clearfix").children:
            name_reg = re.compile(r'<a class="img-anchor" href="(.*?)" target="_blank" title="(.*?)">', re.S)
            url_contents = re.findall(name_reg, str(li))
            # print(url_contents)
            name = url_contents[0][1]
            url_items = 'https:' + url_contents[0][0]
            url_src.append(url_items)
            url_name.append(name)
        for i, k in zip(url_src, url_name):
            url_all.append([i, k])
        return url_all

# print(findMove("https://search.bilibili.com/all?keyword=倚天屠龙记").find())
#https://v.qq.com/x/search/?q=%E5%B0%81%E7%A5%9E%E6%BC%94%E4%B9%89



