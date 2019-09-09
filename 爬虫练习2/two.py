import json
from bs4 import BeautifulSoup
from urllib import request, parse
import re

official_movie_link = 'https://v.qq.com/x/cover/r6ri9qkcu66dna8.html'
# 四大天王视频链接，非会员只能看5分钟
get_url = "http://www.wq114.org/tong.php?url=%s" % official_movie_link
get_movie_url = "http://www.wq114.org/x2/api.php"

head = {}
head["User-Agent"] = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)" \
                     " Chrome/67.0.3396.99 Safari/537.36"
req = request.Request(get_url, headers=head)
response = request.urlopen(req)
html = response.read().decode("utf-8")
soup = BeautifulSoup(html, 'lxml')
xunlei_src = soup.iframe["src"]

head2 = head
head2["Referer"] = get_url
get_url_2 = "http://www.wq114.org%s" % xunlei_src
req_2 = request.Request(get_url_2, headers=head2)
# 可以不设置Referer
response_2 = request.urlopen(req_2)
html2 = response_2.read().decode("utf-8")
soup2 = BeautifulSoup(html2, 'lxml')
tag_string = soup2.find_all("script")[-1].string

regex = re.compile("url    : '(.+)',", re.IGNORECASE)
final_url = regex.findall(tag_string)

get_movie_data = {'up': '0', 'url': "%s" % final_url[0]}
get_movie_req = request.Request(get_movie_url, headers=head)
get_movie_data = parse.urlencode(get_movie_data).encode('utf-8')
get_movie_response = request.urlopen(get_movie_req, get_movie_data)
get_movie_html = get_movie_response.read().decode("utf-8")

final_response = json.loads(get_movie_html)
add_url = final_response["url"]

to_see_url = "http://www.wq114.org/tong.php?url=%s" % add_url
# 整合好的在线视频链接
print(to_see_url)
