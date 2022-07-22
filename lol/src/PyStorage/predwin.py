import sys
import os
from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
import joblib
import numpy as np
import xgboost as xgb
import pandas as pd
import tensorflow as tf
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

def win_pred(red1,red2,red3,red4,red5,blue1,blue2,blue3,blue4,blue5):
	loaded_model1=joblib.load('/home/ubuntu/jardir/src/PyStorage/model/neural_network_model.pkl')
	#loaded_model1=joblib.load('C:/Users/wjdgn/git/bigdata_lol_projcet/lol/src/PyStorage/model/neural_network_model.pkl')
	x=pd.DataFrame({'blue_777':[0],'blue_234':[0],'blue_4':[0],'blue_236':[0],'blue_350':[0],'blue_8':[0],'blue_62':[0],'blue_142':[0],'blue_145':[0],'blue_497':[0],'blue_78':[0],'blue_64':[0],'blue_268':[0],'blue_235':[0],'blue_50':[0],'blue_164':[0],'blue_104':[0],'blue_127':[0],'blue_37':[0],'blue_887':[0],'blue_48':[0],'blue_111':[0],'blue_113':[0],'blue_223':[0],'blue_79':[0],'blue_81':[0],'blue_221':[0],'blue_3':[0],'blue_10':[0],'blue_888':[0],'blue_131':[0],'blue_157':[0],'blue_429':[0],'blue_41':[0],'blue_498':[0],'blue_68':[0],'blue_12':[0],'blue_254':[0],'blue_112':[0],'blue_166':[0],'blue_91':[0],'blue_163':[0],'blue_141':[0],'blue_103':[0],'blue_523':[0],'blue_43':[0],'blue_117':[0],'blue_44':[0],'blue_120':[0],'blue_24':[0],'blue_76':[0],'blue_16':[0],'blue_267':[0],'blue_85':[0],'blue_55':[0],'blue_92':[0],'blue_84':[0],'blue_266':[0],'blue_39':[0],'blue_29':[0],'blue_246':[0],'blue_69':[0],'blue_875':[0],'blue_7':[0],'blue_18':[0],'blue_53':[0],'blue_14':[0],'blue_526':[0],'blue_126':[0],'blue_30':[0],	'blue_54':[0],	'blue_96':[0],	'blue_245':[0],	'blue_154':[0],	'blue_238':[0],	'blue_412':[0],	'blue_61':[0],	'blue_517':[0],	'blue_56':[0],	'blue_89':[0],	'blue_421':[0],	'blue_51':[0],	'blue_555':[0],	'blue_19':[0],	'blue_711':[0],'blue_202':[0],'blue_23':[0],'blue_360':[0],'blue_121':[0],	'blue_134':[0],	'blue_45':[0],	'blue_432':[0],	'blue_115':[0],	'blue_2':[0],	'blue_200':[0],	'blue_42':[0],	'blue_201':[0],	'blue_150':[0],	'blue_102':[0],	'blue_33':[0],	'blue_5':[0],	'blue_13':[0],	'blue_119':[0],	'blue_114':[0],	'blue_516':[0],	'blue_122':[0],	'blue_82':[0],	'blue_80':[0],	'blue_40':[0],	'blue_22':[0],	'blue_75':[0],	'blue_203':[0],'blue_26':[0],'blue_876':[0],'blue_106':[0],'blue_110':[0],'blue_58':[0],'blue_101':[0],'blue_25':[0],'blue_133':[0],'blue_63':[0],	'blue_105':[0],	'blue_34':[0],	'blue_240':[0],	'blue_222':[0],	'blue_72':[0],	'blue_99':[0],	'blue_60':[0],	'blue_518':[0],	'blue_107':[0],	'blue_86':[0],	'blue_147':[0],	'blue_427':[0],	'blue_36':[0],	'blue_67':[0],	'blue_57':[0],	'blue_20':[0],	'blue_136':[0],	'blue_27':[0],	'blue_38':[0],	'blue_59':[0],	'blue_15':[0],	'blue_98':[0],	'blue_83':[0],	'blue_32':[0],	'blue_28':[0],'blue_77':[0],	'blue_21':[0],	'blue_420':[0],	'blue_1':[0],	'blue_35':[0],	'blue_17':[0],	'blue_11':[0],	'blue_9':[0],	'blue_31':[0],	'blue_6':[0],	'blue_143':[0],	'blue_161':[0],	'blue_74':[0],	'blue_90':[0],	'red_79':[0],	'red_64':[0],	'red_517':[0],	'red_429':[0],	'red_267':[0],	'red_42':[0],	'red_164':[0],	'red_498':[0],	'red_555':[0],	'red_104':[0],	'red_4':[0],	'red_81':[0],	'red_43':[0],	'red_62':[0],	'red_103':[0],	'red_350':[0],	'red_254':[0],	'red_3':[0],	'red_200':[0],	'red_777':[0],	'red_246':[0],	'red_142':[0],	'red_236':[0],	'red_82':[0],	'red_234':[0],	'red_145':[0],	'red_111':[0],	'red_268':[0],	'red_223':[0],	'red_157':[0],	'red_119':[0],	'red_888':[0],	'red_7':[0],	'red_18':[0],	'red_235':[0],	'red_126':[0],	'red_131':[0],	'red_2':[0],	'red_203':[0],	'red_163':[0],	'red_45':[0],	'red_115':[0],	'red_12':[0],	'red_85':[0],	'red_91':[0],	'red_523':[0],	'red_68':[0],	'red_887':[0],	'red_711':[0],	'red_360':[0],	'red_76':[0],	'red_54':[0],	'red_166':[0],	'red_106':[0],	'red_141':[0],	'red_876':[0],	'red_412':[0],	'red_22':[0],	'red_113':[0],	'red_29':[0],	'red_89':[0],	'red_266':[0],	'red_39':[0],	'red_56':[0],	'red_41':[0],	'red_51':[0],	'red_121':[0],	'red_19':[0],	'red_421':[0],	'red_78':[0],	'red_117':[0],	'red_107':[0],	'red_15':[0],	'red_53':[0],	'red_134':[0],	'red_98':[0],	'red_875':[0],	'red_102':[0],	'red_238':[0],	'red_201':[0],	'red_61':[0],	'red_202':[0],	'red_58':[0],	'red_497':[0],	'red_84':[0],	'red_13':[0],	'red_96':[0],	'red_432':[0],	'red_221':[0],	'red_10':[0],	'red_23':[0],	'red_48':[0],	'red_24':[0],	'red_30':[0],	'red_114':[0],	'red_222':[0],	'red_33':[0],	'red_26':[0],	'red_44':[0],	'red_92':[0],'red_120':[0],'red_105':[0],'red_8':[0],'red_245':[0],'red_50':[0],'red_122':[0],'red_77':[0],'red_112':[0],'red_516':[0],'red_69':[0],'red_67':[0],'red_110':[0],'red_150':[0],'red_14':[0],'red_36':[0],'red_55':[0],'red_86':[0],'red_40':[0],'red_147':[0],'red_16':[0],'red_59':[0],'red_127':[0],'red_526':[0],'red_25':[0],'red_133':[0],'red_17':[0],'red_20':[0],'red_99':[0],'red_27':[0],'red_80':[0],'red_38':[0],'red_72':[0],'red_154':[0],'red_75':[0],'red_5':[0],'red_32':[0],'red_518':[0],'red_31':[0],'red_34':[0],'red_60':[0],'red_161':[0],'red_90':[0],'red_101':[0],'red_427':[0],'red_28':[0],'red_74':[0],'red_83':[0],'red_1':[0],'red_21':[0],'red_63':[0],'red_136':[0],'red_240':[0],'red_6':[0],'red_57':[0],'red_9':[0],'red_35':[0],'red_11':[0],'red_143':[0],'red_420':[0],'red_37':[0]})
	champcode=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,48,50,51,53,54,55,56,57,58,59,60,61,62,63,64,67,68,69,72,74,75,76,77,78,79,80,81,82,83,84,85,86,89,90,91,92,96,98,99,101,102,103,104,105,106,107,110,111,112,113,114,115,117,119,120,121,122,126,127,131,133,134,136,141,142,143,145,147,150,154,157,161,163,164,166,200,201,202,203,221,222,223,234,235,236,238,240,245,246,254,266,267,268,350,360,412,420,421,427,429,432,497,498,516,517,518,523,526,555,711,777,875,876,887,888]
	x_predict=[red1,red2,red3,red4,red5,blue1,blue2,blue3,blue4,blue5]
	for i in x_predict:
	    for j in champcode:
	  	    if i.split('_')[0]=='blue':
	  	    	if i.split('_')[1]==f'{j}':
	  	    		x[f'blue_{j}']=1
	  	    elif i.split('_')[0]=='red':
	  	    	if i.split('_')[1]==f'{j}':
	  	    		x[f'red_{j}']=1
	print("결과물 : ",loaded_model1.predict(x, verbose=0)[0][0])

def main(argv):
    win_pred(argv[1], argv[2],argv[3],argv[4],argv[5],argv[6],argv[7],argv[8],argv[9],argv[10])

if __name__ == "__main__":
    main(sys.argv)
    


