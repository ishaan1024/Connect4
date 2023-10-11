<HTML>
    <HEAD>
        <TITLE>Connect 4 by Ishaan</TITLE>
        <STYLE>
            #content{
                width:708px;
                height: 800px;
                margin-top: 0px;
                margin:auto;
                background:blue;

            }
            #menu{
                margin-top: 0px;
                width: 100%;
                height: 70px;
                background:red;
                text-align:center;

            }
            #leaderboard{
                float: left;
            }
            label {
                display: inline-block;
                width: 50px;
                text-align: right;
            }
            input[type="text"] {
                margin-top: 0px;
                margin-left: 5px;
                width:100px;
            }
            input[type="hidden"] {
                margin-top: 0px;
                margin-left: 5px;
                font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
                color: gold;
                width:20px;
            }
            .center{
                width: 60%;
                display: block;
                margin-left: auto;
                margin-right: auto;
            }
            .menuWriting{
                margin-top: 0px;
                height: 10px;
                font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
                color: gold;
            }
            .leaderboardWriting{
                margin-top: 0px;
                font-size: 20px;
                font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
            }

        </STYLE>
    </HEAD>
        <BODY id ="body">
            <p id="leaderboard" class="leaderboardWriting">Leaderboard: </p>
            <DIV id = "content">
                <img src="https://i1.wp.com/baytekentlive.wpengine.com/wp-content/uploads/2017/06/connect4logo.png?resize=352%2C102&ssl=1" height = "120" class="center">
                <DIV ID = "menu">
                    <p class="menuWriting">Player1, which column would you like to play in?</p>
                    <form method="post" action="hello">
                            <input type = "hidden" name="player" class = "menuWriting"  value = "%Player%">
                           <label for="column" class="menuWriting">Column:</label>
                           <input type="number" max="7" min="1" name="column">
                           <input type="submit" value="Submit">
                     </form>

                </DIV>
                <canvas id="myCanvas" width="708" height="615"></canvas>
            </DIV>
            <SCRIPT>
                var width =708;
                var height=615;
                var counter_width=100;
                var counter_height=100;
                var cols=width/counter_width;
                var rows = height/counter_height;
                var img = document.createElement("img");
                var canvas = document.getElementById("myCanvas");
                var ctx = canvas.getContext("2d");
                ctx.clearRect(0,0,width,height);
                for(i = 0;i<=7;i++){
                    ctx.beginPath();
                    ctx.lineWidth = "5"
                    ctx.strokeStyle = "darkBlue";
                    ctx.rect(i*100, 0, 5, height-15);
                    ctx.stroke();

                }
                ctx.beginPath();
                ctx.lineWidth = "5"
                ctx.strokeStyle = "darkBlue";
                ctx.rect(0, height-15, width-3, 5);
                ctx.stroke();
                var win = 0;
                var name;
                </SCRIPT>




        </BODY>
















    </HTML>