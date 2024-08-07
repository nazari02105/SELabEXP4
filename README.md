# SELabEXP4
| نام          | شماره دانشجویی|
| ------------- | ------------- |
| علیرضا عالیپناه                  | 99106396      |
| سیدمحمدیوسف نجفی      | 99102361      |
| علی نظری                        | 99102401      |


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
