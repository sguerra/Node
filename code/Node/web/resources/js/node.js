$(document).ready(function()
{
    Node.Init();
});


var Node = (function()
{
    var LoadEvents = function()
    {
        $(".btn-get-skill").click(OnClickBtnSkills);
        $(".btn-get-employment").click(OnClickBtnEmployments);
    }
    
    var OnClickBtnSkills = function()
    {
        doPetition("./skill.get");
    }
    var OnClickBtnEmployments = function()
    {
        doPetition("./employment.get");
    }
    
    var doPetition = function(url)
    {
        $.post(url,function(data)
            {
                alert(JSON.stringify(data));
            }
        );
    }
    
    return {
        Init: function()
        {
            LoadEvents();
        }
    }
})();