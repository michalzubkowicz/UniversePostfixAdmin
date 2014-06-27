define(function(require){
    return {
        getLabels:function(){
            return $.ajax({
                url: '/admin/label/',
                type: 'GET'
            });
        },
        getMailboxes:function(skip){
            return $.ajax({
                url: '/admin/mailbox/'+skip,
                type: 'GET'
            });
        }
    };
});