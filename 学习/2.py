import requests

url = 'https://mapi-pc.vip.com/vips-mobile/rest/layout/pc/channel_b/data'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/142.0.0.0 Safari/537.36 Edg/142.0.0.0',
    'Referer': 'https://www.vip.com/'
}

try:
    res = requests.get(url, headers=headers, timeout=10)
    res.raise_for_status()  # 检查HTTP状态码，如果是4xx或5xx会抛出异常
    
    print("状态码:", res.status_code)
    print("响应内容:")
    print(res.text)
    
except requests.exceptions.RequestException as e:
    print(f"请求出错: {e}")