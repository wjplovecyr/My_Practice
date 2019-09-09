import urllib
import requests

url = 'http://pic.netbian.com/'
headers = {
    # 'Referer:http':'//pic.netbian.com/downpic.php?id=23364&classid=53',
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.4482.400 QQBrowser/9.7.13001.400',}

resp = requests.get(url,headers = headers)
resp = resp.text
resp = resp.encode('utf-8')

from lxml import etree
html = etree.HTML(resp)
srcs = html.xpath('.//img/@src')
for src in srcs:
    filename = src.split('/')[-1]
    src='http://pic.netbian.com'+src

    # img = requests.get(src,headers = headers)
    img = requests.get(src)
    with open('imgs/'+filename,'wb') as file:
        file.write(img.content)
    # print(src,'\n',filename)

'''<span><img src="/uploads/allimg/180906/180605-1536228365101e.jpg" 
alt="\xc2\xb1\xc3\xb9\xc2\xb9\xc2\xab\xc3\x96\xc3\xb7\xc2\xba\xc2\xa3\
xc3\x87\xc3\x99\xc3\x91\xc3\x8c \xc2\xb1\xc2\xb1\xc3\x84\xc2\xae\xc2\xb9\
xc2\xab\xc3\x96\xc3\xb7\xc2\xb7\xc3\xa7\xc3\x81\xc3\xa1 \xc3\x8e\xc3\xa8\
xc2\xbb\xc3\xa1 \xc2\xb9\xc3\xad\xc2\xb5\xc2\xb64k\xc2\xb1\xc3\x9a\xc3\x96\xc2\xbd" /></span>


http://pic.netbian.com'''
# response = urllib.request.urlopen('http://math.sysu.edu.cn/main/default/index.aspx')
# html = response.read()
# html = html.decode('utf-8')
# print(html)
