import re

import bs4
import requests
#
#
def get(url):
    try:
        html = requests.get(url,timeout=30)
        html.raise_for_status()  # 如果状态不是200，引发HTTPError异常
        html.encoding = html.apparent_encoding
        r = requests.get(url)
        with open("D://小电影测试//aaa.mp4",'wb') as f:
            f.write(r.content)
            f.close()
        return html.text
    except:
        return "产生异常"


if __name__ == "__main__":
    url = "http://v.kd1.qq.com/shg_321_1116_6X000000000000000000000000tk7Y2l.f620.mp4?dis_k=69805e2812c0875e41f629ed8b5433ff&dis_t=1556016444"
    # Keyword = input();
    # kw = {'keyword': Keyword}
    print(get(url))
# def getHTMLText(url):
#     try:
#         r = requests.get(url, timeout=30)
#         r.raise_for_status()
#         r.encoding = r.apparent_encoding
#         return r.text
#     except:
#         return ""
# from bs4 import BeautifulSoup
#
#
# def fillUnivList(html):
#     url_src = []
#     url_name = []
#     url_all = []
#     soup = BeautifulSoup(html, "html.parser")
#     for li in soup.find('ul',class_ = "video-contain clearfix").children:
#         name_reg = re.compile(r'<a class="img-anchor" href="(.*?)" target="_blank" title="(.*?)">', re.S)
#         url_contents = re.findall(name_reg,str(li))
#         # print(url_contents)
#         name = url_contents[0][1]
#         url_items = 'https:'+url_contents[0][0]
#         url_src.append(url_items)
#         url_name.append(name)
#     for i, k in zip(url_src,url_name):
#         url_all.append([i,k])
#     print(url_all)
#
#
# # def printUnivList(ulist, num):
# #     tplt = "{0:^10}\t{1:{3}^10}\t{2:^10}"
# #     print(tplt.format("排名", "学校名称", "总分", chr(12288)))
# #     for i in range(num):
# #         u = ulist[i]
# #         print(tplt.format(u[0], u[1], u[2], chr(12288)))
#
#
# def main():
#     url = 'https://search.bilibili.com/all?keyword=%E6%B5%B7%E8%B4%BC%E7%8E%8B&from_source=banner_search&spm_id_from=333.334.b_62616e6e65725f6c696e6b.1'
#     html = getHTMLText(url)
#     fillUnivList(html)
#
#
#
# main()