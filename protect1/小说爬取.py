import requests
import time
from bs4 import BeautifulSoup
url = 'https://www.gushicimingju.com/novel/xiyouji/'
headers = {
        "User-Agent": "MyApp/1.0",
        "Accept-Language": "zh-CN",
        "Content-Type": "application/json",
        "Authorization": "Basic dXNlcjpwYXNz"}
xiaosuo_ = requests.get(url=url,headers=headers)
xiaosuo_ .encoding = 'utf-8'
xiaosuo_soup = BeautifulSoup(xiaosuo_.text,'html.parser')
xiaosuo_biaoti_ = xiaosuo_soup.select('.main-content a')
for i in xiaosuo_biaoti_:
    xiaosuo_biaoti = i.text.strip()
    url1 = 'https://www.gushicimingju.com'+i['href']
    xiaosuo__ = requests.get(url1)
    xiaosuo_.encoding='utf-8'
    xiaosuo_soup_ = BeautifulSoup(xiaosuo__.text,'html.parser')
    xiaosuo= xiaosuo_soup_.select_one('.shici-content')
    if xiaosuo:
        xiaosuo_text = xiaosuo.get_text()
    else:
        xiaosuo_text= 'no'
    print(xiaosuo_biaoti)
    with open(f'./xiyouji/{xiaosuo_biaoti}.txt','w',encoding='utf-8')as f:
        f.write(xiaosuo_text)
    time.sleep(1)