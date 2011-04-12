<%-- 
    Document   : js_menu
    Created on : 06/01/2011, 11:32:46
    Author     : fabio
--%>
        <link rel="stylesheet" href="../css/estilo.css" type="text/css">
        <link rel="stylesheet" href="../css/jquery-ui-1.8.7.custom.css" type="text/css">

        <script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
        <script type="text/javascript" src="../js/jquery.ui.core.js"></script>
        <script type="text/javascript" src="../js/jquery.ui.widget.js"></script>
        <script type="text/javascript" src="../js/jquery.ui.accordion.js"></script>
        <!--[if IE]><script language="javascript" type="text/javascript" src="../js/excanvas.js"></script><![endif]-->
        <script type="text/javascript" src="../js/jquery.jqplot.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../js/jquery.jqplot.css" />

        <script type="text/javascript">
            $(document).ready(function(){
                $("#lista_servidores").accordion({
                    autoHeight: false
                });
                $.jqplot('chartdiv',  [[[1, 2],[3,5.12],[5,13.1],[7,33.6],[9,85.9],[11,219.9]]]);
            });
        </script>
