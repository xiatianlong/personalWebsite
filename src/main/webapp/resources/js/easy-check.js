/**
 * 字符串常用工具类
 * Author:Xiatl
 * Date:2017-08-22
 */
(function() {
	var EasyCheck = EasyCheck || {};
	//区域
	// EasyCheck.areas= AREAS||{};
	//手机相关的校验
	EasyCheck.PhoneUtils = {
		regexs: {
			//中国电信
			CHINA_TELECOM_PATTERN: /^(?:\+86)?1(?:33|53|7[37]|8[019])\d{8}$|^(?:\+86)?1700\d{7}$/,
			//中国联通
			CHINA_UNICOM_PATTERN: /^(?:\+86)?1(?:3[0-2]|4[5]|5[56]|7[56]|8[56])\d{8}$|^(?:\+86)?170[7-9]\d{7}$/,
			//中国移动
			CHINA_MOBILE_PATTERN: /^(?:\+86)?1(?:3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\d{8}$|^(?:\+86)?1705\d{7}$/,
			//座机
			PHONE_CALL_PATTERN: /^(?:\(\d{3,4}\)|\d{3,4}-)?\d{7,8}(?:-\d{1,4})?$/,
			//手机号码
			PHONE_PATTERN: /^(?:\+86)?(?:13\d|14[57]|15[0-35-9]|17[35-8]|18\d)\d{8}$|^(?:\+86)?170[057-9]\d{7}$/,
			//手机号简单校验(11位简单校验)
			PHONE_SIMPLE_PATTERN: /^(?:\+86)?1\d{10}$/
		},
        //是否是手机号码（只校验长度）
        isPhoneNumBySize: function(value) {
            return this.regexs.PHONE_SIMPLE_PATTERN.test(value);
        },
        //手机号码（严格校验）
        isPhoneNum: function(value) {
            return this.regexs.PHONE_PATTERN.test(value);
        },
		//手机号码（电信）
		isChinaTelecomPhoneNum: function(value) {
			return this.regexs.CHINA_TELECOM_PATTERN.test(value);
		},
		//手机号码（联通）
		isChinaUnicomPhoneNum: function(value) {
			return this.regexs.CHINA_UNICOM_PATTERN.test(value);
		},
        //手机号码（移动）
		isChinaMobilePhoneNum: function(value) {
			return this.regexs.CHINA_MOBILE_PATTERN.test(value);
		},
        //是否是电话号码
        isPhoneCallNum: function(value) {
            return this.regexs.PHONE_CALL_PATTERN.test(value);
        }
	};
	//邮箱校验
	EasyCheck.EmailUtils = {
		regexs: {
			EMAIL_PATTERN: /^[-\w\+]+(?:\.[-\w]+)*@[-a-z0-9]+(?:\.[a-z0-9]+)*(?:\.[a-z]{2,})$/i
		},
		//邮箱格式校验
		isEmail: function(value) {
			return this.regexs.EMAIL_PATTERN.test(value);
		}
	};
	//字符串相关校验
	EasyCheck.StringUtils = {
		// 空字符串
		isEmpty: function(value) {
            return value == null || value == "" || typeof (value) == "undefined";
		},
		// 不是空字符串
		isNotEmpty: function(value) {
			return !this.isEmpty(value);
		},
		// 空字符串，可为空格
		isBlank: function(value) {
			return value == null || /^\s*$/.test(value);
		},
        // 不是空字符串，也不是空格
		isNotBlank: function(value) {
			return !this.isBlank(value);
		},
        // 去掉前后空格
		trim: function(value) {
			return value.replace(/^\s+|\s+$/, '');
		},
		// 是否以某个字符串开头
		startsWith: function(value, prefix) {
			return value.indexOf(prefix) === 0;
		},
        // 是否以某个字符串结束
		endsWith: function(value, suffix) {
			return value.lastIndexOf(suffix) === 0;
		},
		// 是否包含某个字符串
		contains: function(value, searchSeq) {
			return value.indexOf(searchSeq) >= 0;
		},
        // 是否和某个字符串相等
		equals: function(value1, value2) {
			return value1 == value2;
		},
        // 是否和某个字符串相等（不区分大小写）
		equalsIgnoreCase: function(value1, value2) {
			return value1.toLocaleLowerCase() == value2.toLocaleLowerCase();
		},
		// 是否包含空格
		containsWhitespace: function(value) {
			return this.contains(value, ' ');
		},
		//生成指定个数的字符
		repeat: function(value, cnt) {
			var result = "";
			for(var i = 0; i < cnt; i++) {
				result += value;
			}
			return result;
		},
		// 删除空格
		deleteWhitespace: function(value) {
			return value.replace(/\s+/g, ' ');
		},
		// 右侧补全
		rightPad: function(value, size, padStr) {
			return value + this.repeat(padStr, size);
		},
		// 左侧补全
		leftPad: function(value, size, padStr) {
			return this.repeat(padStr, size) + value;
		},
		//首字符大写
		capitalize: function(value) {
			var strLen = 0;
			if(value == null || (strLen = value.length) == 0) {
				return value;
			}
			return value.replace(/^[a-z]/, function(matchStr) {
				return matchStr.toLocaleUpperCase();
			});
		},
		//首字母小写
		uncapitalize: function(value) {
			var strLen = 0;
			if(value == null || (strLen = value.length) == 0) {
				return value;
			}
			return value.replace(/^[A-Z]/, function(matchStr) {
				return matchStr.toLocaleLowerCase();
			});
		},
		//大小写互转
		swapCase: function(value) {
			return value.replace(/[a-z]/ig, function(matchStr) {
				if(matchStr >= 'A' && matchStr <= 'Z') {
					return matchStr.toLocaleLowerCase();
				} else if(matchStr >= 'a' && matchStr <= 'z') {
					return matchStr.toLocaleUpperCase();
				}
			});
		},
		//获取字符串中某个个字符串出现的次数
		countMatches: function(value, sub) {
			if(this.isEmpty(value) || this.isEmpty(sub)) {
				return 0;
			}
			var count = 0;
			var index = 0;
			while((index = value.indexOf(sub, index)) != -1) {
				index += sub.length;
				count++;
			}
			return count;
		},
		// 是否只包含字母
		isAlpha: function(value) {
			return /^[a-z]+$/i.test(value);
		},
		// 是否只包含字母、空格
		isAlphaSpace: function(value) {
			return /^[a-z\s]*$/i.test(value);
		},
		// 是否只包含字母、数字
		isAlphanumeric: function(value) {
			return /^[a-z0-9]+$/i.test(value);
		},
		// 是否只包含字母、数字和空格
		isAlphanumericSpace: function(value) {
			return /^[a-z0-9\s]*$/i.test(value);
		},
		// 是否只是数字
		isNumeric: function(value) {
			return /^(?:[1-9]\d*|0)(?:\.\d+)?$/.test(value);
		},
		// 是否是小数
		isDecimal: function(value) {
			return /^[-+]?(?:0|[1-9]\d*)\.\d+$/.test(value);
		},
		// 是否是负小数
		isNegativeDecimal: function(value) {
			return /^\-?(?:0|[1-9]\d*)\.\d+$/.test(value);
		},
		// 是否是正小数
		isPositiveDecimal: function(value) {
			return /^\+?(?:0|[1-9]\d*)\.\d+$/.test(value);
		},
		// 是否是整数
		isInteger: function(value) {
			return /^[-+]?(?:0|[1-9]\d*)$/.test(value);
		},
		// 是否是正整数
		isPositiveInteger: function(value) {
			return /^\+?(?:0|[1-9]\d*)$/.test(value);
		},
		// 是否是负整数
		isNegativeInteger: function(value) {
			return /^\-?(?:0|[1-9]\d*)$/.test(value);
		},
		// 是否只包含数字和空格
		isNumericSpace: function(value) {
			return /^[\d\s]*$/.test(value);
		},
		// 是否全为小写字母
		isAllLowerCase: function(value) {
			return /^[a-z]+$/.test(value);
		},
		// 是否全为大写字母
		isAllUpperCase: function(value) {
			return /^[A-Z]+$/.test(value);
		},
		//字符串反转
		reverse: function(value) {
			if(this.isBlank(value)) {
				value;
			}
			return value.split("").reverse().join("");
		},
		/**
		 * @param {String} message
		 * @param {Array} arr
		 * 消息格式化
		 */
		format: function(message, arr) {
			return message.replace(/{(\d+)}/g, function(matchStr, group1) {
				return arr[group1];
			});
		},
		/**
		 * 把连续出现多次的字母字符串进行压缩。如输入:xxxxtttl  输出:4x3t1l
		 * @param {String} value
		 * @param {Boolean} ignoreCase : true or false 
		 */
		compressRepeatedStr: function(value, ignoreCase) {
			var pattern = new RegExp("([a-z])\\1+", ignoreCase ? "ig" : "g");
			return result = value.replace(pattern, function(matchStr, group1) {
				return matchStr.length + group1;
			});
		},
		//中文校验
		isChinese: function(value) {
			return /^[\u4E00-\u9FA5]+$/.test(value);
		},
		//去掉字符串中的中文字符
		removeChinese: function(value) {
			return value.replace(/[\u4E00-\u9FA5]+/gm, "");
		},
		//转义字符串中的元字符
		escapeMetacharacterOfStr: function(value) {
			return value.replace(/[-$^()*+.\[\]|\\?{}]/gm, "\\$&");
		},
		//中文转为unicode编码
		chineseToUnicode: function(value) {
			return value.replace(/[\u4E00-\u9FA5]/g, function(matchStr) {
				return "\\u" + matchStr.charCodeAt(0).toString(16);　　　　　　
			});
		}

	};
	//身份证校验
	EasyCheck.IdCardUtils = {			
		regex: {
			//18位身份证简单校验
			IDCARD_18_SIMPLE_PATTERN: /^(?:1[1-5]|2[1-3]|3[1-7]|4[1-6]|5[0-4]|6[1-5])\d{4}(?:1[89]|20)\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\d|3[01])\d{3}(?:\d|[xX])$/,
			//15位身份证简单校验
			IDCARD_15_SIMPLE_PATTERN: /^(?:1[1-5]|2[1-3]|3[1-7]|4[1-6]|5[0-4]|6[1-5])\d{4}\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\d|3[01])\d{3}$/
		},
		//18位身份证简单校验
		isIdCard18Simple: function(idCard) {
			return this.regex.IDCARD_18_SIMPLE_PATTERN.test(idCard);
		},
		//15位身份证简单校验
		isIdCard15Simple: function(idCard) {
			return this.regex.IDCARD_15_SIMPLE_PATTERN.test(idCard);
		},
		//18位身份证校验码校验
		checkCode: function(idCard) {
			// 加权因子
			var multiplier = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
			var idDatas = idCard.split("");
			var len = 17;
			var sum = 0;
			for(var i = 0; i < len; i++) {
				sum += idDatas[i] * multiplier[i];
			}
			var remainder = sum % 11;
			// 身份证验证位值
			var checkCodeArr = ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'];
			var checkCode = checkCodeArr[remainder];
			return checkCode === idCard[17];
		},
		//18位身份证严格校验
		isIdCard: function(idCard) {
			//先校验格式
			if(this.isSimpleIdCard18(idCard)) {
				//校验日期时间是否合法
				var birthDay = idCard.substr(6, 8);
				var birthDayNew = birthDay.replace(/(\d{4})(\d{2})(\d{2})/, "$1/$2/$3");
				var dateObj = new Date(birthDayNew);
				var month = dateObj.getMonth() + 1;
				if(parseInt(birthDay.substr(4, 2)) === month) {
					return this.checkCode(idCard);
				}
			}
			return false;
		},
		//根据身份证号码获取人员信息(仅限18位)
		getPersonInfo:function(idCard){
			var address=EasyCheck.areas[idCard.substr(0,2)+'0000']+' '+EasyCheck.areas[idCard.substr(0,4)+'00']+' '+EasyCheck.areas[idCard.substr(0,6)];
			var sex=(idCard.substr(16,1)%2===0)?'女':'男';
			var birthday=idCard.substr(6,8).replace(/(\d{4})(\d{2})(\d{2})/,'$1年$2月$3日');
			var age=new Date().getFullYear()-idCard.substr(6,4)+1;
            return {'address':address,'sex':sex,'birthday':birthday,'age':age};
		}
	};
	// 数组校验
	EasyCheck.ArrayUtils = {
		//获取数组最大值
		getMaxValue: function(array) {
			return Math.max.apply(Math, array);
		},
		//获取数组最小值
		getMinValue: function(array) {
			return Math.min.apply(Math, array);
		}
	};
	//DateUtils命名空间
	EasyCheck.DateUtils = {
		patterns: {
			PATTERN_ERA: 'G', //Era 标志符 Era strings. For example: "AD" and "BC"
			PATTERN_YEAR: 'y', //年
			PATTERN_MONTH: 'M', //月份
			PATTERN_DAY_OF_MONTH: 'd', //月份的天数
			PATTERN_HOUR_OF_DAY1: 'k', //一天中的小时数（1-24）
			PATTERN_HOUR_OF_DAY0: 'H', //24小时制，一天中的小时数（0-23）
			PATTERN_MINUTE: 'm', //小时中的分钟数
			PATTERN_SECOND: 's', //秒
			PATTERN_MILLISECOND: 'S', //毫秒
			PATTERN_DAY_OF_WEEK: 'E', //一周中对应的星期，如星期一，周一
			PATTERN_DAY_OF_YEAR: 'D', //一年中的第几天
			PATTERN_DAY_OF_WEEK_IN_MONTH: 'F', //一月中的第几个星期(会把这个月总共过的天数除以7,不够准确，推荐用W)
			PATTERN_WEEK_OF_YEAR: 'w', //一年中的第几个星期
			PATTERN_WEEK_OF_MONTH: 'W', //一月中的第几星期(会根据实际情况来算)
			PATTERN_AM_PM: 'a', //上下午标识
			PATTERN_HOUR1: 'h', //12小时制 ，am/pm 中的小时数（1-12）
			PATTERN_HOUR0: 'K', //和h类型
			PATTERN_ZONE_NAME: 'z', //时区名
			PATTERN_ZONE_VALUE: 'Z', //时区值
			PATTERN_WEEK_YEAR: 'Y', //和y类型
			PATTERN_ISO_DAY_OF_WEEK: 'u',
			PATTERN_ISO_ZONE: 'X'
		},
		week: {
			'ch': {
				"0": "\u65e5",
				"1": "\u4e00",
				"2": "\u4e8c",
				"3": "\u4e09",
				"4": "\u56db",
				"5": "\u4e94",
				"6": "\u516d"
			},
			'en': {
				"0": "Sunday",
				"1": "Monday",
				"2": "Tuesday",
				"3": "Wednesday",
				"4": "Thursday",
				"5": "Friday",
				"6": "Saturday"
			}
		},
		//获取当前时间（栗子：2017-11-11 11:11:11）
		getCurrentTime: function() {
			var today = new Date();
			var year = today.getFullYear();
			var month = today.getMonth() + 1;
			var day = today.getDate();
			var hours = today.getHours();
			var minutes = today.getMinutes();
			var seconds = today.getSeconds();
            return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
		},
		/*
		 * 比较时间大小
		 * time1>time2 return 1
		 * time1<time2 return -1
		 * time1==time2 return 0
		 */
		compareTime: function(time1, time2) {
			if(Date.parse(time1.replace(/-/g, "/")) > Date.parse(time2.replace(/-/g, "/"))) {
				return 1;
			} else if(Date.parse(time1.replace(/-/g, "/")) < Date.parse(time2.replace(/-/g, "/"))) {
				return -1;
			} else if(Date.parse(time1.replace(/-/g, "/")) == Date.parse(time2.replace(/-/g, "/"))) {
				return 0;
			}
		},
		//是否闰年
		isLeapYear: function(year) {
			return((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0);
		},
		//获取某个月的天数，从0开始
		getDaysOfMonth: function(year, month) {
			return [31, (this.isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month];
		},
		/*距离现在几天的日期：负数表示今天之前的日期，0表示今天，整数表示未来的日期
		 * 如-1表示昨天的日期，0表示今天，2表示后天
		 */
		fromToday: function(days) {
			var today = new Date();
			today.setDate(today.getDate() + days);
			var date = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
			return date;
		},
		/**
		 * 日期时间格式化
		 * @param {Object} dateTime 需要格式化的日期时间
		 * @param {String} pattern  格式化的模式，如yyyy-MM-dd hh(HH):mm:ss.S a k K E D F w W z Z
		 */
		format: function(dateTime, pattern) {
			var date = new Date(dateTime);
			if(EasyCheck.StringUtils.isBlank(pattern)) {
				return date.toLocaleString();
			}
			return pattern.replace(/([a-z])\1*/ig, function(matchStr, group1) {
				var replacement = "";
				switch(group1) {
					case EasyCheck.DateUtils.patterns.PATTERN_ERA: //G
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_WEEK_YEAR: //Y
					case EasyCheck.DateUtils.patterns.PATTERN_YEAR: //y
						replacement = date.getFullYear();
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_MONTH: //M
						var month = date.getMonth() + 1;
						replacement = (month < 10 && matchStr.length >= 2) ? "0" + month : month;
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_DAY_OF_MONTH: //d
						replacement = (date.getDate() < 10 && matchStr.length >= 2) ? "0" + date.getDate() : date.getDate();
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_HOUR_OF_DAY1: //k(1~24)
						replacement = date.getHours();
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_HOUR_OF_DAY0: //H(0~23)
						replacement = (date.getHours() < 10 && matchStr.length >= 2) ? "0" + date.getHours() : date.getHours();
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_MINUTE: //m
						replacement = (date.getMinutes() < 10 && matchStr.length >= 2) ? "0" + date.getMinutes() : date.getMinutes();
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_SECOND: //s
						replacement = (date.getSeconds() < 10 && matchStr.length >= 2) ? "0" + date.getSeconds() : date.getSeconds();
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_MILLISECOND: //S
						replacement = date.getMilliseconds();
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_DAY_OF_WEEK: //E
						replacement = EasyCheck.DateUtils.week['ch'][date.getDay()];
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_DAY_OF_YEAR: //D
						replacement = EasyCheck.DateUtils.dayOfTheYear(date);
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_DAY_OF_WEEK_IN_MONTH: //F
						replacement = Math.floor(date.getDate() / 7);
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_WEEK_OF_YEAR: //w
						replacement = Math.ceil(EasyCheck.DateUtils.dayOfTheYear(date) / 7);
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_WEEK_OF_MONTH: //W
						replacement = Math.ceil(date.getDate() / 7);
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_AM_PM: //a
						replacement = date.getHours() < 12 ? "\u4e0a\u5348" : "\u4e0b\u5348";
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_HOUR1: //h(1~12)
						var hours12 = date.getHours() % 12 || 12; //0转为12
						replacement = (hours12 < 10 && matchStr.length >= 2) ? "0" + hours12 : hours12;
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_HOUR0: //K(0~11)
						replacement = date.getHours() % 12;
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_ZONE_NAME: //z
						replacement = EasyCheck.DateUtils.getZoneNameValue(date)['name'];
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_ZONE_VALUE: //Z
						replacement = EasyCheck.DateUtils.getZoneNameValue(date)['value'];
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_ISO_DAY_OF_WEEK: //u
						break;
					case EasyCheck.DateUtils.patterns.PATTERN_ISO_ZONE: //X
						break;
					default:
						break;
				}
				return replacement;
			});
		},
		/**
		 * 计算一个日期是当年的第几天
		 * @param {Object} date
		 */
		dayOfTheYear: function(date) {
			var obj = new Date(date);
			var year = obj.getFullYear();
			var month = obj.getMonth(); //从0开始
			var days = obj.getDate();
			var daysArr = [31, (this.isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
			for(var i = 0; i < month; i++) {
				days += daysArr[i];
			}
			return days;
		},
		//获得时区名和值
		getZoneNameValue: function(dateObj) {
			var date = new Date(dateObj);
			date = new Date(Date.UTC(date.getFullYear(), date.getMonth(), date.getDate()));
			var arr = date.toString().match(/([A-Z]+)([-+]\d+:?\d+)/);
            return {
				'name': arr[1],
				'value': arr[2]
			};
		}
	};


	window['EasyCheck'] = EasyCheck;
})();
