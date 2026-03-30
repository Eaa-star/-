import requests
from bs4 import BeautifulSoup
import time
def n(n):
    url = f'https://pic.netbian.com/4k/index_{n}.html'
    headers = {
        "User-Agent": "MyApp/1.0",
        "Accept-Language": "zh-CN",
        "Content-Type": "application/json",
        "Authorization": "Basic dXNlcjpwYXNz"}
    tupian = requests.get(url=url,headers=headers)
    tupian.encoding='gbk'
    soup = BeautifulSoup(tupian.text,'html.parser')
    tupian_biaoti_timu = soup.select('.slist img')
    for i in tupian_biaoti_timu:
        tupian_src='https://pic.netbian.com/'+i['src']
        respons = requests.get(tupian_src)
        tupian_biaoti = i['alt'].replace('*','_')
        print(tupian_biaoti)
        with open(f'./tupian/{tupian_biaoti}.png','wb')as f:
            f.write(respons.content)    
        time.sleep(1)
for i in range(2,4):
    n(i)

