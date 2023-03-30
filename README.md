Implementing OpenAI tools into springBoot app

ChatGPT / Whisper / Dall-e
----------------------------------------------------------------------------------------------------------------------------------

Use of tools above :

get your API-KEY from : https://platform.openai.com/account/api-keys and paste it into api-key property in application.yml
Using tools with postman :
----------------------------------------------------------------------------------------------------------------------------------

Chat GPT: Navigate to : http://localhost:8080/api/send in json format you put your own question, for example:

POST { "message": "When first PC was invented?" }

ChatBot gives back the answer
----------------------------------------------------------------------------------------------------------------------------------

DALL-E (image Generation) Navigate to : http://localhost:8080/api/generate

in json format, you can write your own prompt, available sizes are : 256x256, 512x512 or 1024x1024. Other sizes are not supported num_images availaible range from 1 to 10. Other numbers are not Supported

POST { "prompt":"happy programmer", "size": "512x512", "num_images": 1 }

AI gives back the url to generated image
----------------------------------------------------------------------------------------------------------------------------------

WHISPER - TRANSCRIPTION Navigate to : http://localhost:8080/api/transcription

POST In body, check form-data, then choose file from your machine in format of : mp3, mp4, mpeg, mpga, m4a, wav, or webm.
Max file size is 25MB

AI gives in return transcripted text of audio file
----------------------------------------------------------------------------------------------------------------------------------

WHISPER - TRANSLATION Navigate to : http://localhost:8080/api/translation
Max file size is 25MB

POST In body, check form-data, then choose file from your machine in format of : mp3, mp4, mpeg, mpga, m4a, wav, or webm.

AI gives in return translated into english text from non-english audio file

/////////////////////////////////////////////////////////////
Dockerized version of app is kept under :
https://hub.docker.com/repository/docker/pludynia/openai_api_springboot/general
