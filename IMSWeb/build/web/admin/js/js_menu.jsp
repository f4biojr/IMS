<%-- 
    Document   : js_menu
    Created on : 06/01/2011, 11:32:46
    Author     : fabio
--%>

        <link rel="stylesheet" href="../css/jquery-ui-1.8.7.custom.css" type="text/css">

        <script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
        <script type="text/javascript" src="../js/jquery.ui.core.js"></script>
        <script type="text/javascript" src="../js/jquery.ui.widget.js"></script>
        <script type="text/javascript" src="../js/jquery.ui.accordion.js"></script>

        <script type="text/javascript">
            $(document).ready(function(){
                $("ul.subnav").parent().append("<span></span>"); //Only shows drop down trigger when js is enabled (Adds empty span tag after ul.subnav*)

                $("ul.topnav li span").click(function() { //When trigger is clicked...

                        //Following events are applied to the subnav itself (moving subnav up and down)
                        $(this).parent().find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click

                        $(this).parent().hover(function() {
                        }, function(){
                                $(this).parent().find("ul.subnav").slideUp('slow'); //When the mouse hovers out of the subnav, move it back up
                        });

                        //Following events are applied to the trigger (Hover events for the trigger)
                        }).hover(function() {
                                $(this).addClass("subhover"); //On hover over, add class "subhover"
                        }, function(){	//On Hover Out
                                $(this).removeClass("subhover"); //On hover out, remove class "subhover"
                });
            });
        </script>
