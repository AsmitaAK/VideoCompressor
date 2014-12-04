cordova.define("com.sanda.plugins.WatermarkDetector.WatermarkDetector", function(require, exports, module) { var exec = require('cordova/exec');

module.exports = {

   
     
    start: function(successCallback, errorCallback) {
        //exec(successCallback, errorCallback, "ContactVcardPicker", "getContactVcard", []);
        exec(successCallback, errorCallback, 'VideoCompressor', 'start', []);
    },
};

});

function success(data)
{
alert("success"+data); 
}

 function failure(data)
{
alert("failure");
}