<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>4eachblog 掲示板</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    
    <body>
     <?php
      
      mb_internal_encoding("utf8");
      $pdo=new PDO("mysql:dbname=yama;host=localhost;","root","mysql");
      $stmt=$pdo->query("select*from 4each_keijiban");
      
      
    ?>
        <div class="logo">
            <img src="4eachblog_logo.jpg">
        </div>
        
        <header>
            <ul>
                <li>トップ</li>
                <li>プロフィール</li>
                <li>4eachについて</li>
                <li>登録フォーム</li>
                <li>問い合わせ</li>
                <li>その他</li>
            </ul>
        </header>
        
        <main>
            <div class="left">    
                <h2>プログラミングに役立つ掲示板</h2>

                <div class="form">
                    <h3>入力フォーム</h3>
                    <form method="post" action="insert.php">
                        <label>ハンドルネーム</label>
                        <br>
                        <input type="text" class="text" name="handlename" size="35">
                        <br>
                        <label>タイトル</label>
                        <br>
                        <input type="text" class="text" name="title" size="35">
                        <br>
                        <label>コメント</label>
                        <br>
                        <textarea name="comments" rows="6" cols="50"></textarea>
                        <br>
                        <input type="submit" value="投稿する" class="button">

                    </form>
                </div>
                
                
          
          </div>
            
          <div class="right">
                <h3>人気の記事</h3>
                <ul>
                    <li>PHPオススメ本</li>
                    <li>PHP MyAdminの使い方</li>
                    <li>今人気のエディタTop5</li>
                    <li>HTMLの基礎</li>
                </ul>
                <h3>オススメリンク</h3>
                <ul>
                    <li>インターノウス株式会社</li>
                    <li>XAMPPのダウンロード</li>
                    <li>Eclipseのダウンロード</li>
                    <li>Braketsのダウンロード</li>
                </ul>
                <h3>カテゴリ</h3>
                <ul>
                    <li>HTML</li>
                    <li>PHP</li>
                    <li>MySQL</li>
                    <li>JavaScript</li>
                </ul>
          </div>
          
          <div class="kiji">
               <?php

                while($row=$stmt->fetch()){

                  echo"<div class='keijiban'>";
                  echo"<h3>".$row['title']."</h3>";
                  echo"<p class='nakami'>".$row['comments']."</p>";
                  echo"<p class='name'>posted by".$row['handlename']."</p>";
                  echo"</div>";
                }
              ?>
          </div>
            
        </main>
      
      <footer>copyright internous | 4each blog is the one which provides A to Z about programming.</footer>
        
        
    </body>


</html>