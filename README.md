# SELabEXP4
| نام          | شماره دانشجویی|
| ------------- | ------------- |
| علیرضا عالیپناه                  | 99106396      |
| سیدمحمدیوسف نجفی      | 99102361      |
| علی نظری                        | 99102401      |

برای بخش BDD طبق مراحل پیش میرویم:
ایجاد پروژه جدید maven در Intellij:
![image](https://github.com/user-attachments/assets/3c04e9f8-2a5f-453c-9697-8e36afb74dd6)
سپس به فایل pom.xml می‌رویم و dependency های مورد نیاز پروژه را به آن اضافه می‌کنیم:
![image](https://github.com/user-attachments/assets/c1335d0b-190b-4946-9cf9-69bcd2957dff)
حال از navigation bar سمت راست صفحه maven->test را ران میکنیم تا Build success را ببینیم:
![image](https://github.com/user-attachments/assets/21cebdeb-a711-46c7-b141-33b09c55798e)

حال بقیه مراحل را نیز طبق دستور کار پیش می‌رویم که عکس های آن قرار داده شده است:
![image](https://github.com/user-attachments/assets/7142260d-151c-4090-9302-a97ab38e95ba)

![image](https://github.com/user-attachments/assets/4edbfc3d-8af6-40df-959f-3337368e9d3b)

![image](https://github.com/user-attachments/assets/da8fb2f4-7828-49e5-9239-0aa56fd9bbd2)

![image](https://github.com/user-attachments/assets/58b4124f-008a-467d-97e9-ea3934e5b189)

![image](https://github.com/user-attachments/assets/f7fd81e7-092c-4846-8918-8e22efaedbc3)

![image](https://github.com/user-attachments/assets/9e99bfbe-7ea3-4b21-85ca-b7935e7ce960)

![image](https://github.com/user-attachments/assets/9104c9f1-fb80-44dc-9a7c-3bb0b664c7c0)

در اینجا بدنه ی توابع را پیاده سازی میکنیم:
![image](https://github.com/user-attachments/assets/fa286e5c-f9b4-4889-8ebb-7a7f550f1ca1)

کلاس Calculator را در مسیر src/main/java/calculator درست می‌کنیم:
![image](https://github.com/user-attachments/assets/1f61de84-8bd3-47e6-92eb-860e3744dd60)

این بار maven -> test را میزنیم و به ارور میخوریم.
![image](https://github.com/user-attachments/assets/e7f9e847-a2b2-443a-afe7-be9cdce9c238)

برای رفع این خطا لازم است نسخه بالاتری از Maven را در فایل pom.xml معرفی کنیم. 
که با اضافه کردن خطوط زیر به این فایل پس از پایان dependencies انجام میشود:
<properties>
 <maven.compiler.source>1.8</maven.compiler.source>
 <maven.compiler.target>1.8</maven.compiler.target>
</properties>

![image](https://github.com/user-attachments/assets/64da23a3-6614-4c98-8f9f-7e435e69eb6c)
مجددا maven->test را میزنیم و این بار build success می‌شود:
![image](https://github.com/user-attachments/assets/e2e96693-1b7e-4939-8fcd-2d247388ab61)

بر روی فایل calculator.feature کلیک راست می‌کنیم و گزینه run را انتخاب می‌کنیم تا سناریوی این feature ران شود:
![image](https://github.com/user-attachments/assets/0a327d80-5709-4636-8d85-3341f2e62901)

نتیجه اجرا به صورت زیر است که نشان می‌دهد سناریو موفقیت آمیز تست شده است:
![image](https://github.com/user-attachments/assets/358e394b-604f-4f7c-a08b-16d40311dc6a)


در مسیر test/java/calculator یک کلاس جدید به اسم RunnerTest.java ایجاد می‌کنیم:
![image](https://github.com/user-attachments/assets/23d04fdd-1bad-4e8c-906a-3a953f4bcdfd)

با زدن فلش سبز کنار اسم کلاس این فایل ران می‌شود ولی متوجه یک مشکل دیگر می‌شویم:
![image](https://github.com/user-attachments/assets/fb6d4795-7d5b-440e-b0b8-6211547a16b6)

خطایی که نشان دهنده ی عدم یافتن فایل feature است.
برای رفع آن خط زیر را به ابتدای فایل RunnerTest.java اضافه می‌کنیم.
@CucumberOptions(features = "src/test/resources/features")

با اجرای مجدد آن خروجی به صورت زیر نمایش داده می‌شود:
![image](https://github.com/user-attachments/assets/e9f95ec6-5a02-47f5-ace9-dffa04368bca)

با تغییر مقادیر feature و اعداد می توان نتیجه را تست کرد:
![image](https://github.com/user-attachments/assets/6cb4ba00-066a-49f3-815e-f9b0fe93deab)

حال به شکل زیر به ایجاد تست scenario outline می‌پردازیم:
![image](https://github.com/user-attachments/assets/329d071d-db57-46a3-8c84-df34d7f15f7f)

و با ران کردن دوباره ی RunnerTest برخی تست ها به مشکل undefined میخورند:
![image](https://github.com/user-attachments/assets/10df59ba-5988-41a3-ac15-2ea66fffd635)

جواب سوال پایانی این بخش: 
مورد -1 و 6 و 5.
این موضوع به دلیل این است که نحوه ای که توابع ما نوشته شده اند، با استفاده از رجکس بوده است و قرار است رجکس ارقام را تشخیص دهد، اما یک عدد منفی در این فرمت رجکس به درستی تشخیص داده نمیشود چون رجکسی که نوشته شده، برای تشخیص یک رقم یا بیشتر است، و نه علامت مثبت و منفی. پس عدد منفی به درستی تشخیص داده نمی‌شود و برای همین ارور undefined می‌دهد.
حال برای حل این مشکل کافیست رجکس را به صورت زیر تغییر بدهیم:
![image](https://github.com/user-attachments/assets/214119a4-ac1d-4202-a2f6-0293f184347b)
به این شکل حالتی که هر کدام از اعداد منفی باشند را نیز در نظر گرفته ایم.
حال دوباره تست ها را با کد تغییر یافته ران می‌کنیم و نتیجه به شکل زیر است:
![image](https://github.com/user-attachments/assets/21979bf0-56cd-4c0b-9d40-e08327925064)
می‌بینیم که همه ی تست ها موفقیت آمیز بوده اند.
در اینجا بخش 2 این آزمایش که Scenario outline نوشتن بود به پایان میرسد. کد نهایی این بخش نیز در فولد BDD گیت قابل مشاهده است.





در گام اول بخش 
profiling
نیاز بود تا 
YourKit
را نصب کنیم که همین کار را هم انجام دادیم:

<p align="center">
  <img src="./images/install.png" />
</p>

و سپس مرحله‌های فعال‌سازی را جلو می‌بریم:

<p align="center">
  <img src="./images/activate1.png" />
</p>

<p align="center">
  <img src="./images/activate2.png" />
</p>

<p align="center">
  <img src="./images/activate3.png" />
</p>

سپس به این مرحله می‌رسیم که این ابزار را با 
Intellij
همراه کنیم که در عکس‌های زیر، سلسله مراتب انجام آن را قرار دادیم:

<p align="center">
  <img src="./images/integrate1.png" />
</p>

<p align="center">
  <img src="./images/integrate2.png" />
</p>

<p align="center">
  <img src="./images/integrate3.png" />
</p>

حال به مرحله 
profile 
کردن برنامه می‌رسیم که به شکل زیر آغاز می‌شود:

<p align="center">
  <img src="./images/javacup1.png" />
</p>

ولی این برنامه انقدر رم مصرف می‌کند که ارور
out of memory
را دریافت می‌کنیم:

<p align="center">
  <img src="./images/javacup2.png" />
</p>

مصرف منابع هم به شکل زیر بوده است:

<p align="center">
  <img src="./images/javacup3.png" />
</p>

<p align="center">
  <img src="./images/javacup4.png" />
</p>

حال باید ببینیم کدام متد بوده که مصرف بیش از اندازه داشته است که با بررسی‌های انجام شده و عکس‌های زیر متوجه می‌شویم که متد 
temp
بوده است:

<p align="center">
  <img src="./images/javacup5.png" />
</p>

<p align="center">
  <img src="./images/javacup6.png" />
</p>

دلیل این مصرف بیش از اندازه هم حلقه تو در تو به تعداد زیاد و اضافه کردن تعداد زیادی عدد به یک آرایه است که باعث شده هم مصرف 
cpu
یک پیک بزند و هم مصرف مموری.

روی نقطه پیک هم که کلیک کنیم، می‌بینیم که همان تابع 
temp
است که دارد اجرا می‌شود و باعث این پیک شده است:

<p align="center">
  <img src="./images/javacup7.png" />
</p>

حال به مرحله‌ای می‌رسیم که کد موجود را بهبود بدهیم. برای اینکار همانطور که می‌دانیم، 
ArrayList
چون حالت داینامیک دارد هم رم بسیار زیادی مصرف می‌کند و هم اضافه و کم کردن عضو به آن کندتر است و در این سناریو که ما می‌دانیم چه تعداد داده قرار است به آرایه اضافه شود، می‌توانیم از آرایه معمولی استفاده کنیم:

<p align="center">
  <img src="./images/temp.png" />
</p>

حال مجدد برنامه را 
profile
می‌کنیم و همانطور که دیده می‌شود دیگر ارور
out of memory 
را دریافت نمی‌کنیم و برنامه به درستی ران می‌شود:

<p align="center">
  <img src="./images/javacup8.png" />
</p>

حال نتایح پروفایل برنامه هم به شکل زیر است:

<p align="center">
  <img src="./images/javacup9.png" />
</p>

<p align="center">
  <img src="./images/javacup10.png" />
</p>

زمان اجرا 
temp
با اینکه باز بیشتری مقدار بین بقیه است ولی نسبت به قبلی به میزان خیلی زیادی کمتر شده است:

<p align="center">
  <img src="./images/javacup11.png" />
</p>

در نهایت روی پیک هم که کلیک کنیم، دیگر روی 
temp
گیر نکرده است و همه مراحل جلو رفته است و خود پیک هم بسیار کوچک‌تر شده است:

<p align="center">
  <img src="./images/javacup12.png" />
</p>

برای بخش دوم که یک الگوریتم خودمان باید بگذاریم که اول خوب نباشد ولی بعدش خوب بشود، تصمیم گرفتیم که ضرب ماتریسی را انتخاب کنیم. در روش غیر افیشنت، کل ماتریس را دانه دانه ضرب می‌کنیم و جلو می‌رویم که عکس کد آن به این شکل است:

<p align="center">
  <img src="./images/mul1.png" />
</p>

این کد در فایل
OurOwnAlgorithmBad.java
قرار دارد و آن را پروفایل می‌کنیم:

<p align="center">
  <img src="./images/inefficient1.png" />
</p>

همانطور که دیده می‌شود این برنامه در کل مصرف 
cpu
بالایی دارد و هراز گاهی هم پیک می‌زند که روی یکی از پیک‌ها کلیک کنیم به شکل زیر است:

<p align="center">
  <img src="./images/inefficient3.png" />
</p>

که مشخص است از همان متد ضرب ماتریس است. حال زمان اجرای این برنامه هم بسیار بد است:

<p align="center">
  <img src="./images/inefficient2.png" />
</p>

حال برنامه را با روش 
tile
کردن بهبود می‌دهیم به این شکل که ماتریس را به تعدادی 
tile
تقسیم‌بندی می‌کنیم و اول این 
tile
ها را ضرب می‌کنیم و به شکل پله‌ای جلو می‌رویم:

<p align="center">
  <img src="./images/mul2.png" />
</p>

حال این برنامه را 
profile
می‌کنیم:

<p align="center">
  <img src="./images/efficient1.png" />
</p>

که مشخص است دیگر پیکی نداریم و زمان اجرا هم به شکل قابل توجهی کاهش پیدا کرده است:

<p align="center">
  <img src="./images/efficient2.png" />
</p>

این برنامه چون برای هر دو دو ماتریس با اندازه یکسان می‌سازد و نتیجه هم در ماتریس جدیدی می‌گذارد، مصرف رم و مموری هر دو دقیقا یکسان است و برای همین به آن در گزارش اشاره‌ای نشده است.
