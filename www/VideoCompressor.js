 		cordova.define("com.sanda.videoCompressor.VideoCompressor", 
				 function(require, exports, module) 
				 {
	 				var exec = require('cordova/exec');

					 module.exports = {
							 start: function(successCallback, errorCallback) {
							        //exec(successCallback, errorCallback, "ContactVcardPicker", "getContactVcard", []);
							        exec(successCallback, errorCallback, 'VideoCompressor', 'start', []);
							    }
				};
		});
