import os
import json
from dotenv import load_dotenv
import requests
from datetime import datetime, timedelta

load_dotenv()

CURRENT_DIR = os.path.dirname(os.path.abspath(__file__))
SITE_DIR = os.path.dirname(CURRENT_DIR)

NEWS_API_URL = 'https://newsapi.org/v2/everything'
NEWS_API_KEY = os.getenv('NEWS_API_KEY')
NEWS_CACHE_FILE = os.path.join(SITE_DIR, 'cache_noticias.json')
CACHE_EXPIRATION_HOURS = 8

def fetch_news():
    if os.path.exists(NEWS_CACHE_FILE):
        with open(NEWS_CACHE_FILE, 'r') as f:
            cache = json.load(f)
            timestamp = datetime.fromisoformat(cache['timestamp'])
            if datetime.now() - timestamp < timedelta(hours=CACHE_EXPIRATION_HOURS):
                print('Usando cache de notícias')
                return cache['noticias']
    
    print('Buscando novas notícias da API')
    params = {
        'q': 'fitness',
        'apiKey': NEWS_API_KEY,
        'language': 'pt',
        'sortBy': 'publishedAt'
    }
    response = requests.get(NEWS_API_URL, params=params)
    noticias = response.json().get('articles', [])

    for noticia in noticias:
        date = noticia.get('publishedAt')
        try:
            formatted_date = datetime.strptime(date, '%Y-%m-%dT%H:%M:%SZ')
            noticia['publishedAt'] = formatted_date.strftime('%d/%m/%Y %H:%M')
        except:
            pass

    with open(NEWS_CACHE_FILE, 'w') as f:
        json.dump({
            'timestamp': datetime.now().isoformat(),
            'noticias': noticias
            }, f)
    
    return noticias