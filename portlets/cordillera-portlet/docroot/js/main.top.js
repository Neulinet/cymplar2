function initCountrySelectPhone(selectId) {
	var countrySelect = document.getElementById(selectId);
	
	if (countrySelect != null) {
		var options = "" +
//		"<option value='-1'></option>" +
//		"<option code='af' phoneCode='93' value='93'>AF Afghanistan (+93)</option>" +
//		"<option code='al' phoneCode='355' value='355'>AL Albania (+355)</option>" +
//		"<option code='dz' phoneCode='213' value='213'>DZ Algeria (+213)</option>" +
//		"<option code='ad' phoneCode='376' value='376'>AD Andorra (+376)</option>" +
//		"<option code='ao' phoneCode='244' value='244'>AO Angola (+244)</option>" +
//		"<option code='aq' phoneCode='672' value='672'>AQ Antarctica (+672)</option>" +
//		"<option code='ar' phoneCode='54' value='54'>AR Argentina (+54)</option>" +
//		"<option code='am' phoneCode='374' value='374'>AM Armenia (+374)</option>" +
//		"<option code='aw' phoneCode='297' value='297'>AW Aruba (+297)</option>" +
//		"<option code='au' phoneCode='61' value='61'>AU Australia (+61)</option>" +
//		"<option code='at' phoneCode='43' value='43'>AT Austria (+43)</option>" +
//		"<option code='az' phoneCode='994' value='994'>AZ Azerbaijan (+994)</option>" +
//		"<option code='bh' phoneCode='973' value='973'>BH Bahrain (+973)</option>" +
//		"<option code='bd' phoneCode='880' value='880'>BD Bangladesh (+880)</option>" +
//		"<option code='by' phoneCode='375' value='375'>BY Belarus (+375)</option>" +
//		"<option code='be' phoneCode='32' value='32'>BE Belgium (+32)</option>" +
//		"<option code='bz' phoneCode='501' value='501'>BZ Belize (+501)</option>" +
//		"<option code='bj' phoneCode='229' value='229'>BJ Benin (+229)</option>" +
//		"<option code='bt' phoneCode='975' value='975'>BT Bhutan (+975)</option>" +
//		"<option code='bo' phoneCode='591' value='591'>BO Bolivia, (+591)</option>" +
//		"<option code='ba' phoneCode='387' value='387'>BA Bosnia (+387)</option>" +
//		"<option code='bw' phoneCode='267' value='267'>BW Botswana (+267)</option>" +
//		"<option code='br' phoneCode='55' value='55'>BR Brazil (+55)</option>" +
//		"<option code='bn' phoneCode='673' value='673'>BN Brunei (+673)</option>" +
//		"<option code='bg' phoneCode='359' value='359'>BG Bulgaria (+359)</option>" +
//		"<option code='bf' phoneCode='226' value='226'>BF Burkina (+226)</option>" +
//		"<option code='mm' phoneCode='95' value='95'>MM Myanmar (+95)</option>" +
//		"<option code='bi' phoneCode='257' value='257'>BI Burundi (+257)</option>" +
//		"<option code='kh' phoneCode='855' value='855'>KH Cambodia (+855)</option>" +
//		"<option code='cm' phoneCode='237' value='237'>CM Cameroon (+237)</option>" +
//		"<option code='ca' phoneCode='1' value='1'>CA Canada (+1)</option>" +
//		"<option code='cv' phoneCode='238' value='238'>CV Cape (+238)</option>" +
//		"<option code='cf' phoneCode='236' value='236'>CF Central (+236)</option>" +
//		"<option code='td' phoneCode='235' value='235'>TD Chad (+235)</option>" +
//		"<option code='cl' phoneCode='56' value='56'>CL Chile (+56)</option>" +
//		"<option code='cn' phoneCode='86' value='86'>CN China (+86)</option>" +
//		"<option code='cx' phoneCode='61' value='61'>CX Christmas (+61)</option>" +
//		"<option code='cc' phoneCode='61' value='61'>CC Cocos (+61)</option>" +
//		"<option code='co' phoneCode='57' value='57'>CO Colombia (+57)</option>" +
//		"<option code='km' phoneCode='269' value='269'>KM Comoros (+269)</option>" +
//		"<option code='cg' phoneCode='242' value='242'>CG Congo (+242)</option>" +
//		"<option code='cd' phoneCode='243' value='243'>CD Congo, (+243)</option>" +
//		"<option code='ck' phoneCode='682' value='682'>CK Cook (+682)</option>" +
//		"<option code='cr' phoneCode='506' value='506'>CR Costa (+506)</option>" +
//		"<option code='hr' phoneCode='385' value='385'>HR Croatia (+385)</option>" +
//		"<option code='cu' phoneCode='53' value='53'>CU Cuba (+53)</option>" +
//		"<option code='cy' phoneCode='357' value='357'>CY Cyprus (+357)</option>" +
//		"<option code='cz' phoneCode='420' value='420'>CZ Czech (+420)</option>" +
//		"<option code='dk' phoneCode='45' value='45'>DK Denmark (+45)</option>" +
//		"<option code='dj' phoneCode='253' value='253'>DJ Djibouti (+253)</option>" +
//		"<option code='tl' phoneCode='670' value='670'>TL Timor-leste (+670)</option>" +
//		"<option code='ec' phoneCode='593' value='593'>EC Ecuador (+593)</option>" +
//		"<option code='eg' phoneCode='20' value='20'>EG Egypt (+20)</option>" +
//		"<option code='sv' phoneCode='503' value='503'>SV El (+503)</option>" +
//		"<option code='gq' phoneCode='240' value='240'>GQ Equatorial (+240)</option>" +
//		"<option code='er' phoneCode='291' value='291'>ER Eritrea (+291)</option>" +
//		"<option code='ee' phoneCode='372' value='372'>EE Estonia (+372)</option>" +
//		"<option code='et' phoneCode='251' value='251'>ET Ethiopia (+251)</option>" +
//		"<option code='fk' phoneCode='500' value='500'>FK Falkland (+500)</option>" +
//		"<option code='fo' phoneCode='298' value='298'>FO Faroe (+298)</option>" +
//		"<option code='fj' phoneCode='679' value='679'>FJ Fiji (+679)</option>" +
//		"<option code='fi' phoneCode='358' value='358'>FI Finland (+358)</option>" +
//		"<option code='fr' phoneCode='33' value='33'>FR France (+33)</option>" +
//		"<option code='pf' phoneCode='689' value='689'>PF French (+689)</option>" +
//		"<option code='ga' phoneCode='241' value='241'>GA Gabon (+241)</option>" +
//		"<option code='gm' phoneCode='220' value='220'>GM Gambia (+220)</option>" +
//		"<option code='ge' phoneCode='995' value='995'>GE Georgia (+995)</option>" +
//		"<option code='de' phoneCode='49' value='49'>DE Germany (+49)</option>" +
//		"<option code='gh' phoneCode='233' value='233'>GH Ghana (+233)</option>" +
//		"<option code='gi' phoneCode='350' value='350'>GI Gibraltar (+350)</option>" +
//		"<option code='gr' phoneCode='30' value='30'>GR Greece (+30)</option>" +
//		"<option code='gl' phoneCode='299' value='299'>GL Greenland (+299)</option>" +
//		"<option code='gt' phoneCode='502' value='502'>GT Guatemala (+502)</option>" +
//		"<option code='gn' phoneCode='224' value='224'>GN Guinea (+224)</option>" +
//		"<option code='gw' phoneCode='245' value='245'>GW Guinea-bissau (+245)</option>" +
//		"<option code='gy' phoneCode='592' value='592'>GY Guyana (+592)</option>" +
//		"<option code='ht' phoneCode='509' value='509'>HT Haiti (+509)</option>" +
//		"<option code='hn' phoneCode='504' value='504'>HN Honduras (+504)</option>" +
//		"<option code='hk' phoneCode='852' value='852'>HK Hong (+852)</option>" +
//		"<option code='hu' phoneCode='36' value='36'>HU Hungary (+36)</option>" +
//		"<option code='in' phoneCode='91' value='91'>IN India (+91)</option>" +
//		"<option code='id' phoneCode='62' value='62'>ID Indonesia (+62)</option>" +
//		"<option code='ir' phoneCode='98' value='98'>IR Iran, (+98)</option>" +
//		"<option code='iq' phoneCode='964' value='964'>IQ Iraq (+964)</option>" +
//		"<option code='ie' phoneCode='353' value='353'>IE Ireland (+353)</option>" +
//		"<option code='im' phoneCode='44' value='44'>IM Isle (+44)</option>" +
//		"<option code='il' phoneCode='972' value='972'>IL Israel (+972)</option>" +
//		"<option code='it' phoneCode='39' value='39'>IT Italy (+39)</option>" +
//		"<option code='ci' phoneCode='225' value='225'>CI Cote (+225)</option>" +
//		"<option code='jp' phoneCode='81' value='81'>JP Japan (+81)</option>" +
//		"<option code='jo' phoneCode='962' value='962'>JO Jordan (+962)</option>" +
//		"<option code='kz' phoneCode='7' value='7'>KZ Kazakhstan (+7)</option>" +
//		"<option code='ke' phoneCode='254' value='254'>KE Kenya (+254)</option>" +
//		"<option code='ki' phoneCode='686' value='686'>KI Kiribati (+686)</option>" +
//		"<option code='kw' phoneCode='965' value='965'>KW Kuwait (+965)</option>" +
//		"<option code='kg' phoneCode='996' value='996'>KG Kyrgyzstan (+996)</option>" +
//		"<option code='la' phoneCode='856' value='856'>LA Lao (+856)</option>" +
//		"<option code='lv' phoneCode='371' value='371'>LV Latvia (+371)</option>" +
//		"<option code='lb' phoneCode='961' value='961'>LB Lebanon (+961)</option>" +
//		"<option code='ls' phoneCode='266' value='266'>LS Lesotho (+266)</option>" +
//		"<option code='lr' phoneCode='231' value='231'>LR Liberia (+231)</option>" +
//		"<option code='ly' phoneCode='218' value='218'>LY Libya (+218)</option>" +
//		"<option code='li' phoneCode='423' value='423'>LI Liechtenstein (+423)</option>" +
//		"<option code='lt' phoneCode='370' value='370'>LT Lithuania (+370)</option>" +
//		"<option code='lu' phoneCode='352' value='352'>LU Luxembourg (+352)</option>" +
//		"<option code='mo' phoneCode='853' value='853'>MO Macao (+853)</option>" +
//		"<option code='mk' phoneCode='389' value='389'>MK Macedonia, (+389)</option>" +
//		"<option code='mg' phoneCode='261' value='261'>MG Madagascar (+261)</option>" +
//		"<option code='mw' phoneCode='265' value='265'>MW Malawi (+265)</option>" +
//		"<option code='my' phoneCode='60' value='60'>MY Malaysia (+60)</option>" +
//		"<option code='mv' phoneCode='960' value='960'>MV Maldives (+960)</option>" +
//		"<option code='ml' phoneCode='223' value='223'>ML Mali (+223)</option>" +
//		"<option code='mt' phoneCode='356' value='356'>MT Malta (+356)</option>" +
//		"<option code='mh' phoneCode='692' value='692'>MH Marshall (+692)</option>" +
//		"<option code='mr' phoneCode='222' value='222'>MR Mauritania (+222)</option>" +
//		"<option code='mu' phoneCode='230' value='230'>MU Mauritius (+230)</option>" +
//		"<option code='yt' phoneCode='262' value='262'>YT Mayotte (+262)</option>" +
//		"<option code='mx' phoneCode='52' value='52'>MX Mexico (+52)</option>" +
//		"<option code='fm' phoneCode='691' value='691'>FM Micronesia, (+691)</option>" +
//		"<option code='md' phoneCode='373' value='373'>MD Moldova, (+373)</option>" +
//		"<option code='mc' phoneCode='377' value='377'>MC Monaco (+377)</option>" +
//		"<option code='mn' phoneCode='976' value='976'>MN Mongolia (+976)</option>" +
//		"<option code='me' phoneCode='382' value='382'>ME Montenegro (+382)</option>" +
//		"<option code='ma' phoneCode='212' value='212'>MA Morocco (+212)</option>" +
//		"<option code='mz' phoneCode='258' value='258'>MZ Mozambique (+258)</option>" +
//		"<option code='na' phoneCode='264' value='264'>NA Namibia (+264)</option>" +
//		"<option code='nr' phoneCode='674' value='674'>NR Nauru (+674)</option>" +
//		"<option code='np' phoneCode='977' value='977'>NP Nepal (+977)</option>" +
//		"<option code='nl' phoneCode='31' value='31'>NL Netherlands (+31)</option>" +
//		"<option code='nc' phoneCode='687' value='687'>NC New (+687)</option>" +
//		"<option code='nz' phoneCode='64' value='64'>NZ New (+64)</option>" +
//		"<option code='ni' phoneCode='505' value='505'>NI Nicaragua (+505)</option>" +
//		"<option code='ne' phoneCode='227' value='227'>NE Niger (+227)</option>" +
//		"<option code='ng' phoneCode='234' value='234'>NG Nigeria (+234)</option>" +
//		"<option code='nu' phoneCode='683' value='683'>NU Niue (+683)</option>" +
//		"<option code='kp' phoneCode='850' value='850'>KP Korea, (+850)</option>" +
//		"<option code='no' phoneCode='47' value='47'>NO Norway (+47)</option>" +
//		"<option code='om' phoneCode='968' value='968'>OM Oman (+968)</option>" +
//		"<option code='pk' phoneCode='92' value='92'>PK Pakistan (+92)</option>" +
//		"<option code='pw' phoneCode='680' value='680'>PW Palau (+680)</option>" +
//		"<option code='pa' phoneCode='507' value='507'>PA Panama (+507)</option>" +
//		"<option code='pg' phoneCode='675' value='675'>PG Papua (+675)</option>" +
//		"<option code='py' phoneCode='595' value='595'>PY Paraguay (+595)</option>" +
//		"<option code='pe' phoneCode='51' value='51'>PE Peru (+51)</option>" +
//		"<option code='ph' phoneCode='63' value='63'>PH Philippines (+63)</option>" +
//		"<option code='pn' phoneCode='870' value='870'>PN Pitcairn (+870)</option>" +
//		"<option code='pl' phoneCode='48' value='48'>PL Poland (+48)</option>" +
//		"<option code='pt' phoneCode='351' value='351'>PT Portugal (+351)</option>" +
//		"<option code='pr' phoneCode='1' value='1'>PR Puerto Rico (+1)</option>" +
//		"<option code='qa' phoneCode='974' value='974'>QA Qatar (+974)</option>" +
//		"<option code='ro' phoneCode='40' value='40'>RO Romania (+40)</option>" +
//		"<option code='ru' phoneCode='7' value='7'>RU Russian (+7)</option>" +
//		"<option code='rw' phoneCode='250' value='250'>RW Rwanda (+250)</option>" +
//		"<option code='bl' phoneCode='590' value='590'>BL Saint (+590)</option>" +
//		"<option code='ws' phoneCode='685' value='685'>WS Samoa (+685)</option>" +
//		"<option code='sm' phoneCode='378' value='378'>SM San (+378)</option>" +
//		"<option code='st' phoneCode='239' value='239'>ST Sao (+239)</option>" +
//		"<option code='sa' phoneCode='966' value='966'>SA Saudi (+966)</option>" +
//		"<option code='sn' phoneCode='221' value='221'>SN Senegal (+221)</option>" +
//		"<option code='rs' phoneCode='381' value='381'>RS Serbia (+381)</option>" +
//		"<option code='sc' phoneCode='248' value='248'>SC Seychelles (+248)</option>" +
//		"<option code='sl' phoneCode='232' value='232'>SL Sierra (+232)</option>" +
//		"<option code='sg' phoneCode='65' value='65'>SG Singapore (+65)</option>" +
//		"<option code='sk' phoneCode='421' value='421'>SK Slovakia (+421)</option>" +
//		"<option code='si' phoneCode='386' value='386'>SI Slovenia (+386)</option>" +
//		"<option code='sb' phoneCode='677' value='677'>SB Solomon (+677)</option>" +
//		"<option code='so' phoneCode='252' value='252'>SO Somalia (+252)</option>" +
//		"<option code='za' phoneCode='27' value='27'>ZA South (+27)</option>" +
//		"<option code='kr' phoneCode='82' value='82'>KR Korea, (+82)</option>" +
//		"<option code='es' phoneCode='34' value='34'>ES Spain (+34)</option>" +
//		"<option code='lk' phoneCode='94' value='94'>LK Sri (+94)</option>" +
//		"<option code='sh' phoneCode='290' value='290'>SH Saint (+290)</option>" +
//		"<option code='pm' phoneCode='508' value='508'>PM Saint (+508)</option>" +
//		"<option code='sd' phoneCode='249' value='249'>SD Sudan (+249)</option>" +
//		"<option code='sr' phoneCode='597' value='597'>SR Suriname (+597)</option>" +
//		"<option code='sz' phoneCode='268' value='268'>SZ Swaziland (+268)</option>" +
//		"<option code='se' phoneCode='46' value='46'>SE Sweden (+46)</option>" +
//		"<option code='ch' phoneCode='41' value='41'>CH Switzerland (+41)</option>" +
//		"<option code='sy' phoneCode='963' value='963'>SY Syrian (+963)</option>" +
//		"<option code='tw' phoneCode='886' value='886'>TW Taiwan, (+886)</option>" +
//		"<option code='tj' phoneCode='992' value='992'>TJ Tajikistan (+992)</option>" +
//		"<option code='tz' phoneCode='255' value='255'>TZ Tanzania, (+255)</option>" +
//		"<option code='th' phoneCode='66' value='66'>TH Thailand (+66)</option>" +
//		"<option code='tg' phoneCode='228' value='228'>TG Togo (+228)</option>" +
//		"<option code='tk' phoneCode='690' value='690'>TK Tokelau (+690)</option>" +
//		"<option code='to' phoneCode='676' value='676'>TO Tonga (+676)</option>" +
//		"<option code='tn' phoneCode='216' value='216'>TN Tunisia (+216)</option>" +
//		"<option code='tr' phoneCode='90' value='90'>TR Turkey (+90)</option>" +
//		"<option code='tm' phoneCode='993' value='993'>TM Turkmenistan (+993)</option>" +
//		"<option code='tv' phoneCode='688' value='688'>TV Tuvalu (+688)</option>" +
//		"<option code='ae' phoneCode='971' value='971'>AE United (+971)</option>" +
//		"<option code='ug' phoneCode='256' value='256'>UG Uganda (+256)</option>" +
//		"<option code='gb' phoneCode='44' value='44'>GB United (+44)</option>" +
//		"<option code='ua' phoneCode='380' value='380'>UA Ukraine (+380)</option>" +
//		"<option code='uy' phoneCode='598' value='598'>UY Uruguay (+598)</option>" +
//		"<option code='us' phoneCode='1' value='1'>US United (+1)</option>" +
//		"<option code='uz' phoneCode='998' value='998'>UZ Uzbekistan (+998)</option>" +
//		"<option code='vu' phoneCode='678' value='678'>VU Vanuatu (+678)</option>" +
//		"<option code='va' phoneCode='39' value='39'>VA Holy (+39)</option>" +
//		"<option code='ve' phoneCode='58' value='58'>VE Venezuela, (+58)</option>" +
//		"<option code='vn' phoneCode='84' value='84'>VN Viet (+84)</option>" +
//		"<option code='wf' phoneCode='681' value='681'>WF Wallis (+681)</option>" +
//		"<option code='ye' phoneCode='967' value='967'>YE Yemen (+967)</option>" +
//		"<option code='zm' phoneCode='260' value='260'>ZM Zambia (+260)</option>" +
//		"<option code='zw' phoneCode='263' value='263'>ZW Zimbabwe (+263)</option>"
		
		"<option code='ad'  phoneCode='376' value='376ad'>AD Andorra</option>" +
		"<option code='ae'  phoneCode='971' value='971ae'>AE United Arab Emirates</option>" +
		"<option code='af'  phoneCode='93' value='93af'>AF Afghanistan</option>" +
		"<option code='al'  phoneCode='355' value='355al'>AL Albania</option>" +
		"<option code='am'  phoneCode='374' value='374am'>AM Armenia</option>" +
		"<option code='ao'  phoneCode='244' value='244ao'>AO Angola</option>" +
		"<option code='aq'  phoneCode='672' value='672aq'>AQ Antarctica</option>" +
		"<option code='ar'  phoneCode='54' value='54ar'>AR Argentina</option>" +
		"<option code='at'  phoneCode='43' value='43at'>AT Austria</option>" +
		"<option code='au'  phoneCode='61' value='61au'>AU Australia</option>" +
		"<option code='aw'  phoneCode='297' value='297aw'>AW Aruba</option>" +
		"<option code='az'  phoneCode='994' value='994az'>AZ Azerbaijan</option>" +
		"<option code='ba'  phoneCode='387' value='387ba'>BA Bosnia And Herzegovina</option>" +
		"<option code='bd'  phoneCode='880' value='880bd'>BD Bangladesh</option>" +
		"<option code='be'  phoneCode='32' value='32be'>BE Belgium</option>" +
		"<option code='bf'  phoneCode='226' value='226bf'>BF Burkina Faso</option>" +
		"<option code='bg'  phoneCode='359' value='359bg'>BG Bulgaria</option>" +
		"<option code='bh'  phoneCode='973' value='973bh'>BH Bahrain</option>" +
		"<option code='bi'  phoneCode='257' value='257bi'>BI Burundi</option>" +
		"<option code='bj'  phoneCode='229' value='229bj'>BJ Benin</option>" +
		"<option code='bl'  phoneCode='590' value='590bl'>BL Saint Barthelemy</option>" +
		"<option code='bn'  phoneCode='673' value='673bn'>BN Brunei Darussalam</option>" +
		"<option code='bo'  phoneCode='591' value='591bo'>BO Bolivia, Plurinational State Of</option>" +
		"<option code='br'  phoneCode='55' value='55br'>BR Brazil</option>" +
		"<option code='bt'  phoneCode='975' value='975bt'>BT Bhutan</option>" +
		"<option code='bw'  phoneCode='267' value='267bw'>BW Botswana</option>" +
		"<option code='by'  phoneCode='375' value='375by'>BY Belarus</option>" +
		"<option code='bz'  phoneCode='501' value='501bz'>BZ Belize</option>" +
		"<option code='ca'  phoneCode='1' value='1ca'>CA Canada</option>" +
		"<option code='cc'  phoneCode='61' value='61cc'>CC Cocos (keeling) Islands</option>" +
		"<option code='cd'  phoneCode='243' value='243cd'>CD Congo, The Democratic Republic Of The</option>" +
		"<option code='cf'  phoneCode='236' value='236cf'>CF Central African Republic</option>" +
		"<option code='cg'  phoneCode='242' value='242cg'>CG Congo</option>" +
		"<option code='ch'  phoneCode='41' value='41ch'>CH Switzerland</option>" +
		"<option code='ci'  phoneCode='225' value='225ci'>CI Cote D&apos;ivoire</option>" +
		"<option code='ck'  phoneCode='682' value='682ck'>CK Cook Islands</option>" +
		"<option code='cl'  phoneCode='56' value='56cl'>CL Chile</option>" +
		"<option code='cm'  phoneCode='237' value='237cm'>CM Cameroon</option>" +
		"<option code='cn'  phoneCode='86' value='86cn'>CN China</option>" +
		"<option code='co'  phoneCode='57' value='57co'>CO Colombia</option>" +
		"<option code='cr'  phoneCode='506' value='506cr'>CR Costa Rica</option>" +
		"<option code='cu'  phoneCode='53' value='53cu'>CU Cuba</option>" +
		"<option code='cv'  phoneCode='238' value='238cv'>CV Cape Verde</option>" +
		"<option code='cx'  phoneCode='61' value='61cx'>CX Christmas Island</option>" +
		"<option code='cy'  phoneCode='357' value='357cy'>CY Cyprus</option>" +
		"<option code='cz'  phoneCode='420' value='420cz'>CZ Czech Republic</option>" +
		"<option code='de'  phoneCode='49' value='49de'>DE Germany</option>" +
		"<option code='dj'  phoneCode='253' value='253dj'>DJ Djibouti</option>" +
		"<option code='dk'  phoneCode='45' value='45dk'>DK Denmark</option>" +
		"<option code='dz'  phoneCode='213' value='213dz'>DZ Algeria</option>" +
		"<option code='ec'  phoneCode='593' value='593ec'>EC Ecuador</option>" +
		"<option code='ee'  phoneCode='372' value='372ee'>EE Estonia</option>" +
		"<option code='eg'  phoneCode='20' value='20eg'>EG Egypt</option>" +
		"<option code='er'  phoneCode='291' value='291er'>ER Eritrea</option>" +
		"<option code='es'  phoneCode='34' value='34es'>ES Spain</option>" +
		"<option code='et'  phoneCode='251' value='251et'>ET Ethiopia</option>" +
		"<option code='fi'  phoneCode='358' value='358fi'>FI Finland</option>" +
		"<option code='fj'  phoneCode='679' value='679fj'>FJ Fiji</option>" +
		"<option code='fk'  phoneCode='500' value='500fk'>FK Falkland Islands (malvinas)</option>" +
		"<option code='fm'  phoneCode='691' value='691fm'>FM Micronesia, Federated States Of</option>" +
		"<option code='fo'  phoneCode='298' value='298fo'>FO Faroe Islands</option>" +
		"<option code='fr'  phoneCode='33' value='33fr'>FR France</option>" +
		"<option code='ga'  phoneCode='241' value='241ga'>GA Gabon</option>" +
		"<option code='gb'  phoneCode='44' value='44gb'>GB United Kingdom</option>" +
		"<option code='ge'  phoneCode='995' value='995ge'>GE Georgia</option>" +
		"<option code='gh'  phoneCode='233' value='233gh'>GH Ghana</option>" +
		"<option code='gi'  phoneCode='350' value='350gi'>GI Gibraltar</option>" +
		"<option code='gl'  phoneCode='299' value='299gl'>GL Greenland</option>" +
		"<option code='gm'  phoneCode='220' value='220gm'>GM Gambia</option>" +
		"<option code='gn'  phoneCode='224' value='224gn'>GN Guinea</option>" +
		"<option code='gq'  phoneCode='240' value='240gq'>GQ Equatorial Guinea</option>" +
		"<option code='gr'  phoneCode='30' value='30gr'>GR Greece</option>" +
		"<option code='gt'  phoneCode='502' value='502gt'>GT Guatemala</option>" +
		"<option code='gw'  phoneCode='245' value='245gw'>GW Guinea-bissau</option>" +
		"<option code='gy'  phoneCode='592' value='592gy'>GY Guyana</option>" +
		"<option code='hk'  phoneCode='852' value='852hk'>HK Hong Kong</option>" +
		"<option code='hn'  phoneCode='504' value='504hn'>HN Honduras</option>" +
		"<option code='hr'  phoneCode='385' value='385hr'>HR Croatia</option>" +
		"<option code='ht'  phoneCode='509' value='509ht'>HT Haiti</option>" +
		"<option code='hu'  phoneCode='36' value='36hu'>HU Hungary</option>" +
		"<option code='id'  phoneCode='62' value='62id'>ID Indonesia</option>" +
		"<option code='ie'  phoneCode='353' value='353ie'>IE Ireland</option>" +
		"<option code='il'  phoneCode='972' value='972il'>IL Israel</option>" +
		"<option code='im'  phoneCode='44' value='44im'>IM Isle Of Man</option>" +
		"<option code='in'  phoneCode='91' value='91in'>IN India</option>" +
		"<option code='iq'  phoneCode='964' value='964iq'>IQ Iraq</option>" +
		"<option code='ir'  phoneCode='98' value='98ir'>IR Iran, Islamic Republic Of</option>" +
		"<option code='it'  phoneCode='39' value='39it'>IT Italy</option>" +
		"<option code='jo'  phoneCode='962' value='962jo'>JO Jordan</option>" +
		"<option code='jp'  phoneCode='81' value='81jp'>JP Japan</option>" +
		"<option code='ke'  phoneCode='254' value='254ke'>KE Kenya</option>" +
		"<option code='kg'  phoneCode='996' value='996kg'>KG Kyrgyzstan</option>" +
		"<option code='kh'  phoneCode='855' value='855kh'>KH Cambodia</option>" +
		"<option code='ki'  phoneCode='686' value='686ki'>KI Kiribati</option>" +
		"<option code='km'  phoneCode='269' value='269km'>KM Comoros</option>" +
		"<option code='kp'  phoneCode='850' value='850kp'>KP Korea, Democratic People&apos;s Republic Of</option>" +
		"<option code='kr'  phoneCode='82' value='82kr'>KR Korea, Republic Of</option>" +
		"<option code='kw'  phoneCode='965' value='965kw'>KW Kuwait</option>" +
		"<option code='kz'  phoneCode='7' value='7kz'>KZ Kazakhstan</option>" +
		"<option code='la'  phoneCode='856' value='856la'>LA Lao People&apos;s Democratic Republic</option>" +
		"<option code='lb'  phoneCode='961' value='961lb'>LB Lebanon</option>" +
		"<option code='li'  phoneCode='423' value='423li'>LI Liechtenstein</option>" +
		"<option code='lk'  phoneCode='94' value='94lk'>LK Sri Lanka</option>" +
		"<option code='lr'  phoneCode='231' value='231lr'>LR Liberia</option>" +
		"<option code='ls'  phoneCode='266' value='266ls'>LS Lesotho</option>" +
		"<option code='lt'  phoneCode='370' value='370lt'>LT Lithuania</option>" +
		"<option code='lu'  phoneCode='352' value='352lu'>LU Luxembourg</option>" +
		"<option code='lv'  phoneCode='371' value='371lv'>LV Latvia</option>" +
		"<option code='ly'  phoneCode='218' value='218ly'>LY Libya</option>" +
		"<option code='ma'  phoneCode='212' value='212ma'>MA Morocco</option>" +
		"<option code='mc'  phoneCode='377' value='377mc'>MC Monaco</option>" +
		"<option code='md'  phoneCode='373' value='373md'>MD Moldova, Republic Of</option>" +
		"<option code='me'  phoneCode='382' value='382me'>ME Montenegro</option>" +
		"<option code='mg'  phoneCode='261' value='261mg'>MG Madagascar</option>" +
		"<option code='mh'  phoneCode='692' value='692mh'>MH Marshall Islands</option>" +
		"<option code='mk'  phoneCode='389' value='389mk'>MK Macedonia, The Former Yugoslav Republic Of</option>" +
		"<option code='ml'  phoneCode='223' value='223ml'>ML Mali</option>" +
		"<option code='mm'  phoneCode='95' value='95mm'>MM Myanmar</option>" +
		"<option code='mn'  phoneCode='976' value='976mn'>MN Mongolia</option>" +
		"<option code='mo'  phoneCode='853' value='853mo'>MO Macao</option>" +
		"<option code='mr'  phoneCode='222' value='222mr'>MR Mauritania</option>" +
		"<option code='mt'  phoneCode='356' value='356mt'>MT Malta</option>" +
		"<option code='mu'  phoneCode='230' value='230mu'>MU Mauritius</option>" +
		"<option code='mv'  phoneCode='960' value='960mv'>MV Maldives</option>" +
		"<option code='mw'  phoneCode='265' value='265mw'>MW Malawi</option>" +
		"<option code='mx'  phoneCode='52' value='52mx'>MX Mexico</option>" +
		"<option code='my'  phoneCode='60' value='60my'>MY Malaysia</option>" +
		"<option code='mz'  phoneCode='258' value='258mz'>MZ Mozambique</option>" +
		"<option code='na'  phoneCode='264' value='264na'>NA Namibia</option>" +
		"<option code='nc'  phoneCode='687' value='687nc'>NC New Caledonia</option>" +
		"<option code='ne'  phoneCode='227' value='227ne'>NE Niger</option>" +
		"<option code='ng'  phoneCode='234' value='234ng'>NG Nigeria</option>" +
		"<option code='ni'  phoneCode='505' value='505ni'>NI Nicaragua</option>" +
		"<option code='nl'  phoneCode='31' value='31nl'>NL Netherlands</option>" +
		"<option code='no'  phoneCode='47' value='47no'>NO Norway</option>" +
		"<option code='np'  phoneCode='977' value='977np'>NP Nepal</option>" +
		"<option code='nr'  phoneCode='674' value='674nr'>NR Nauru</option>" +
		"<option code='nu'  phoneCode='683' value='683nu'>NU Niue</option>" +
		"<option code='nz'  phoneCode='64' value='64nz'>NZ New Zealand</option>" +
		"<option code='om'  phoneCode='968' value='968om'>OM Oman</option>" +
		"<option code='pa'  phoneCode='507' value='507pa'>PA Panama</option>" +
		"<option code='pe'  phoneCode='51' value='51pe'>PE Peru</option>" +
		"<option code='pf'  phoneCode='689' value='689pf'>PF French Polynesia</option>" +
		"<option code='pg'  phoneCode='675' value='675pg'>PG Papua New Guinea</option>" +
		"<option code='ph'  phoneCode='63' value='63ph'>PH Philippines</option>" +
		"<option code='pk'  phoneCode='92' value='92pk'>PK Pakistan</option>" +
		"<option code='pl'  phoneCode='48' value='48pl'>PL Poland</option>" +
		"<option code='pm'  phoneCode='508' value='508pm'>PM Saint Pierre And Miquelon</option>" +
		"<option code='pn'  phoneCode='870' value='870pn'>PN Pitcairn</option>" +
		"<option code='pr'  phoneCode='1' value='1pr'>PR Puerto Rico</option>" +
		"<option code='pt'  phoneCode='351' value='351pt'>PT Portugal</option>" +
		"<option code='pw'  phoneCode='680' value='680pw'>PW Palau</option>" +
		"<option code='py'  phoneCode='595' value='595py'>PY Paraguay</option>" +
		"<option code='qa'  phoneCode='974' value='974qa'>QA Qatar</option>" +
		"<option code='ro'  phoneCode='40' value='40ro'>RO Romania</option>" +
		"<option code='rs'  phoneCode='381' value='381rs'>RS Serbia</option>" +
		"<option code='ru'  phoneCode='7' value='7ru'>RU Russian Federation</option>" +
		"<option code='rw'  phoneCode='250' value='250rw'>RW Rwanda</option>" +
		"<option code='sa'  phoneCode='966' value='966sa'>SA Saudi Arabia</option>" +
		"<option code='sb'  phoneCode='677' value='677sb'>SB Solomon Islands</option>" +
		"<option code='sc'  phoneCode='248' value='248sc'>SC Seychelles</option>" +
		"<option code='sd'  phoneCode='249' value='249sd'>SD Sudan</option>" +
		"<option code='se'  phoneCode='46' value='46se'>SE Sweden</option>" +
		"<option code='sg'  phoneCode='65' value='65sg'>SG Singapore</option>" +
		"<option code='sh'  phoneCode='290' value='290sh'>SH Saint Helena, Ascension And Tristan Da Cunha</option>" +
		"<option code='si'  phoneCode='386' value='386si'>SI Slovenia</option>" +
		"<option code='sk'  phoneCode='421' value='421sk'>SK Slovakia</option>" +
		"<option code='sl'  phoneCode='232' value='232sl'>SL Sierra Leone</option>" +
		"<option code='sm'  phoneCode='378' value='378sm'>SM San Marino</option>" +
		"<option code='sn'  phoneCode='221' value='221sn'>SN Senegal</option>" +
		"<option code='so'  phoneCode='252' value='252so'>SO Somalia</option>" +
		"<option code='sr'  phoneCode='597' value='597sr'>SR Suriname</option>" +
		"<option code='st'  phoneCode='239' value='239st'>ST Sao Tome And Principe</option>" +
		"<option code='sv'  phoneCode='503' value='503sv'>SV El Salvador</option>" +
		"<option code='sy'  phoneCode='963' value='963sy'>SY Syrian Arab Republic</option>" +
		"<option code='sz'  phoneCode='268' value='268sz'>SZ Swaziland</option>" +
		"<option code='td'  phoneCode='235' value='235td'>TD Chad</option>" +
		"<option code='tg'  phoneCode='228' value='228tg'>TG Togo</option>" +
		"<option code='th'  phoneCode='66' value='66th'>TH Thailand</option>" +
		"<option code='tj'  phoneCode='992' value='992tj'>TJ Tajikistan</option>" +
		"<option code='tk'  phoneCode='690' value='690tk'>TK Tokelau</option>" +
		"<option code='tl'  phoneCode='670' value='670tl'>TL Timor-leste</option>" +
		"<option code='tm'  phoneCode='993' value='993tm'>TM Turkmenistan</option>" +
		"<option code='tn'  phoneCode='216' value='216tn'>TN Tunisia</option>" +
		"<option code='to'  phoneCode='676' value='676to'>TO Tonga</option>" +
		"<option code='tr'  phoneCode='90' value='90tr'>TR Turkey</option>" +
		"<option code='tv'  phoneCode='688' value='688tv'>TV Tuvalu</option>" +
		"<option code='tw'  phoneCode='886' value='886tw'>TW Taiwan, Province Of China</option>" +
		"<option code='tz'  phoneCode='255' value='255tz'>TZ Tanzania, United Republic Of</option>" +
		"<option code='ua'  phoneCode='380' value='380ua'>UA Ukraine</option>" +
		"<option code='ug'  phoneCode='256' value='256ug'>UG Uganda</option>" +
		"<option code='us'  phoneCode='1' value='1us'>US United States</option>" +
		"<option code='uy'  phoneCode='598' value='598uy'>UY Uruguay</option>" +
		"<option code='uz'  phoneCode='998' value='998uz'>UZ Uzbekistan</option>" +
		"<option code='va'  phoneCode='39' value='39va'>VA Holy See (vatican City State)</option>" +
		"<option code='ve'  phoneCode='58' value='58ve'>VE Venezuela, Bolivarian Republic Of</option>" +
		"<option code='vn'  phoneCode='84' value='84vn'>VN Viet Nam</option>" +
		"<option code='vu'  phoneCode='678' value='678vu'>VU Vanuatu</option>" +
		"<option code='wf'  phoneCode='681' value='681wf'>WF Wallis And Futuna</option>" +
		"<option code='ws'  phoneCode='685' value='685ws'>WS Samoa</option>"
		;
//		
//		"<option code='af' phoneCode='93' >Afghanistan</option>" +
//		"<option code='al' phoneCode='355' >Albania</option>" +
//		"<option code='dz' phoneCode='213' >Algeria</option>" +
//		"<option code='ad' phoneCode='376' >Andorra</option>" +
//		"<option code='ao' phoneCode='244' >Angola</option>" +
//		"<option code='aq' phoneCode='672' >Antarctica</option>" +
//		"<option code='ar' phoneCode='54' >Argentina</option>" +
//		"<option code='am' phoneCode='374' >Armenia</option>" +
//		"<option code='aw' phoneCode='297' >Aruba</option>" +
//		"<option code='au' phoneCode='61' >Australia</option>" +
//		"<option code='at' phoneCode='43' >Austria</option>" +
//		"<option code='az' phoneCode='994' >Azerbaijan</option>" +
//		"<option code='bh' phoneCode='973' >Bahrain</option>" +
//		"<option code='bd' phoneCode='880' >Bangladesh</option>" +
//		"<option code='by' phoneCode='375' >Belarus</option>" +
//		"<option code='be' phoneCode='32' >Belgium</option>" +
//		"<option code='bz' phoneCode='501' >Belize</option>" +
//		"<option code='bj' phoneCode='229' >Benin</option>" +
//		"<option code='bt' phoneCode='975' >Bhutan</option>" +
//		"<option code='bo' phoneCode='591' >Bolivia, Plurinational State Of</option>" +
//		"<option code='ba' phoneCode='387' >Bosnia And Herzegovina</option>" +
//		"<option code='bw' phoneCode='267' >Botswana</option>" +
//		"<option code='br' phoneCode='55' >Brazil</option>" +
//		"<option code='bn' phoneCode='673' >Brunei Darussalam</option>" +
//		"<option code='bg' phoneCode='359' >Bulgaria</option>" +
//		"<option code='bf' phoneCode='226' >Burkina Faso</option>" +
//		"<option code='mm' phoneCode='95' >Myanmar</option>" +
//		"<option code='bi' phoneCode='257' >Burundi</option>" +
//		"<option code='kh' phoneCode='855' >Cambodia</option>" +
//		"<option code='cm' phoneCode='237' >Cameroon</option>" +
//		"<option code='ca' phoneCode='1' >Canada</option>" +
//		"<option code='cv' phoneCode='238' >Cape Verde</option>" +
//		"<option code='cf' phoneCode='236' >Central African Republic</option>" +
//		"<option code='td' phoneCode='235' >Chad</option>" +
//		"<option code='cl' phoneCode='56' >Chile</option>" +
//		"<option code='cn' phoneCode='86' >China</option>" +
//		"<option code='cx' phoneCode='61' >Christmas Island</option>" +
//		"<option code='cc' phoneCode='61' >Cocos (keeling) Islands</option>" +
//		"<option code='co' phoneCode='57' >Colombia</option>" +
//		"<option code='km' phoneCode='269' >Comoros</option>" +
//		"<option code='cg' phoneCode='242' >Congo</option>" +
//		"<option code='cd' phoneCode='243' >Congo, The Democratic Republic Of The</option>" +
//		"<option code='ck' phoneCode='682' >Cook Islands</option>" +
//		"<option code='cr' phoneCode='506' >Costa Rica</option>" +
//		"<option code='hr' phoneCode='385' >Croatia</option>" +
//		"<option code='cu' phoneCode='53' >Cuba</option>" +
//		"<option code='cy' phoneCode='357' >Cyprus</option>" +
//		"<option code='cz' phoneCode='420' >Czech Republic</option>" +
//		"<option code='dk' phoneCode='45' >Denmark</option>" +
//		"<option code='dj' phoneCode='253' >Djibouti</option>" +
//		"<option code='tl' phoneCode='670' >Timor-leste</option>" +
//		"<option code='ec' phoneCode='593' >Ecuador</option>" +
//		"<option code='eg' phoneCode='20' >Egypt</option>" +
//		"<option code='sv' phoneCode='503' >El Salvador</option>" +
//		"<option code='gq' phoneCode='240' >Equatorial Guinea</option>" +
//		"<option code='er' phoneCode='291' >Eritrea</option>" +
//		"<option code='ee' phoneCode='372' >Estonia</option>" +
//		"<option code='et' phoneCode='251' >Ethiopia</option>" +
//		"<option code='fk' phoneCode='500' >Falkland Islands (malvinas)</option>" +
//		"<option code='fo' phoneCode='298' >Faroe Islands</option>" +
//		"<option code='fj' phoneCode='679' >Fiji</option>" +
//		"<option code='fi' phoneCode='358' >Finland</option>" +
//		"<option code='fr' phoneCode='33' >France</option>" +
//		"<option code='pf' phoneCode='689' >French Polynesia</option>" +
//		"<option code='ga' phoneCode='241' >Gabon</option>" +
//		"<option code='gm' phoneCode='220' >Gambia</option>" +
//		"<option code='ge' phoneCode='995' >Georgia</option>" +
//		"<option code='de' phoneCode='49' >Germany</option>" +
//		"<option code='gh' phoneCode='233' >Ghana</option>" +
//		"<option code='gi' phoneCode='350' >Gibraltar</option>" +
//		"<option code='gr' phoneCode='30' >Greece</option>" +
//		"<option code='gl' phoneCode='299' >Greenland</option>" +
//		"<option code='gt' phoneCode='502' >Guatemala</option>" +
//		"<option code='gn' phoneCode='224' >Guinea</option>" +
//		"<option code='gw' phoneCode='245' >Guinea-bissau</option>" +
//		"<option code='gy' phoneCode='592' >Guyana</option>" +
//		"<option code='ht' phoneCode='509' >Haiti</option>" +
//		"<option code='hn' phoneCode='504' >Honduras</option>" +
//		"<option code='hk' phoneCode='852' >Hong Kong</option>" +
//		"<option code='hu' phoneCode='36' >Hungary</option>" +
//		"<option code='in' phoneCode='91' >India</option>" +
//		"<option code='id' phoneCode='62' >Indonesia</option>" +
//		"<option code='ir' phoneCode='98' >Iran, Islamic Republic Of</option>" +
//		"<option code='iq' phoneCode='964' >Iraq</option>" +
//		"<option code='ie' phoneCode='353' >Ireland</option>" +
//		"<option code='im' phoneCode='44' >Isle Of Man</option>" +
//		"<option code='il' phoneCode='972' >Israel</option>" +
//		"<option code='it' phoneCode='39' >Italy</option>" +
//		"<option code='ci' phoneCode='225' >Cote D&apos;ivoire</option>" +
//		"<option code='jp' phoneCode='81' >Japan</option>" +
//		"<option code='jo' phoneCode='962' >Jordan</option>" +
//		"<option code='kz' phoneCode='7' >Kazakhstan</option>" +
//		"<option code='ke' phoneCode='254' >Kenya</option>" +
//		"<option code='ki' phoneCode='686' >Kiribati</option>" +
//		"<option code='kw' phoneCode='965' >Kuwait</option>" +
//		"<option code='kg' phoneCode='996' >Kyrgyzstan</option>" +
//		"<option code='la' phoneCode='856' >Lao People&apos;s Democratic Republic</option>" +
//		"<option code='lv' phoneCode='371' >Latvia</option>" +
//		"<option code='lb' phoneCode='961' >Lebanon</option>" +
//		"<option code='ls' phoneCode='266' >Lesotho</option>" +
//		"<option code='lr' phoneCode='231' >Liberia</option>" +
//		"<option code='ly' phoneCode='218' >Libya</option>" +
//		"<option code='li' phoneCode='423' >Liechtenstein</option>" +
//		"<option code='lt' phoneCode='370' >Lithuania</option>" +
//		"<option code='lu' phoneCode='352' >Luxembourg</option>" +
//		"<option code='mo' phoneCode='853' >Macao</option>" +
//		"<option code='mk' phoneCode='389' >Macedonia, The Former Yugoslav Republic Of</option>" +
//		"<option code='mg' phoneCode='261' >Madagascar</option>" +
//		"<option code='mw' phoneCode='265' >Malawi</option>" +
//		"<option code='my' phoneCode='60' >Malaysia</option>" +
//		"<option code='mv' phoneCode='960' >Maldives</option>" +
//		"<option code='ml' phoneCode='223' >Mali</option>" +
//		"<option code='mt' phoneCode='356' >Malta</option>" +
//		"<option code='mh' phoneCode='692' >Marshall Islands</option>" +
//		"<option code='mr' phoneCode='222' >Mauritania</option>" +
//		"<option code='mu' phoneCode='230' >Mauritius</option>" +
//		"<option code='yt' phoneCode='262' >Mayotte</option>" +
//		"<option code='mx' phoneCode='52' >Mexico</option>" +
//		"<option code='fm' phoneCode='691' >Micronesia, Federated States Of</option>" +
//		"<option code='md' phoneCode='373' >Moldova, Republic Of</option>" +
//		"<option code='mc' phoneCode='377' >Monaco</option>" +
//		"<option code='mn' phoneCode='976' >Mongolia</option>" +
//		"<option code='me' phoneCode='382' >Montenegro</option>" +
//		"<option code='ma' phoneCode='212' >Morocco</option>" +
//		"<option code='mz' phoneCode='258' >Mozambique</option>" +
//		"<option code='na' phoneCode='264' >Namibia</option>" +
//		"<option code='nr' phoneCode='674' >Nauru</option>" +
//		"<option code='np' phoneCode='977' >Nepal</option>" +
//		"<option code='nl' phoneCode='31' >Netherlands</option>" +
//		"<option code='nc' phoneCode='687' >New Caledonia</option>" +
//		"<option code='nz' phoneCode='64' >New Zealand</option>" +
//		"<option code='ni' phoneCode='505' >Nicaragua</option>" +
//		"<option code='ne' phoneCode='227' >Niger</option>" +
//		"<option code='ng' phoneCode='234' >Nigeria</option>" +
//		"<option code='nu' phoneCode='683' >Niue</option>" +
//		"<option code='kp' phoneCode='850' >Korea, Democratic People&apos;s Republic Of</option>" +
//		"<option code='no' phoneCode='47' >Norway</option>" +
//		"<option code='om' phoneCode='968' >Oman</option>" +
//		"<option code='pk' phoneCode='92' >Pakistan</option>" +
//		"<option code='pw' phoneCode='680' >Palau</option>" +
//		"<option code='pa' phoneCode='507' >Panama</option>" +
//		"<option code='pg' phoneCode='675' >Papua New Guinea</option>" +
//		"<option code='py' phoneCode='595' >Paraguay</option>" +
//		"<option code='pe' phoneCode='51' >Peru</option>" +
//		"<option code='ph' phoneCode='63' >Philippines</option>" +
//		"<option code='pn' phoneCode='870' >Pitcairn</option>" +
//		"<option code='pl' phoneCode='48' >Poland</option>" +
//		"<option code='pt' phoneCode='351' >Portugal</option>" +
//		"<option code='pr' phoneCode='1' >Puerto Rico</option>" +
//		"<option code='qa' phoneCode='974' >Qatar</option>" +
//		"<option code='ro' phoneCode='40' >Romania</option>" +
//		"<option code='ru' phoneCode='7' >Russian Federation</option>" +
//		"<option code='rw' phoneCode='250' >Rwanda</option>" +
//		"<option code='bl' phoneCode='590' >Saint Barthelemy</option>" +
//		"<option code='ws' phoneCode='685' >Samoa</option>" +
//		"<option code='sm' phoneCode='378' >San Marino</option>" +
//		"<option code='st' phoneCode='239' >Sao Tome And Principe</option>" +
//		"<option code='sa' phoneCode='966' >Saudi Arabia</option>" +
//		"<option code='sn' phoneCode='221' >Senegal</option>" +
//		"<option code='rs' phoneCode='381' >Serbia</option>" +
//		"<option code='sc' phoneCode='248' >Seychelles</option>" +
//		"<option code='sl' phoneCode='232' >Sierra Leone</option>" +
//		"<option code='sg' phoneCode='65' >Singapore</option>" +
//		"<option code='sk' phoneCode='421' >Slovakia</option>" +
//		"<option code='si' phoneCode='386' >Slovenia</option>" +
//		"<option code='sb' phoneCode='677' >Solomon Islands</option>" +
//		"<option code='so' phoneCode='252' >Somalia</option>" +
//		"<option code='za' phoneCode='27' >South Africa</option>" +
//		"<option code='kr' phoneCode='82' >Korea, Republic Of</option>" +
//		"<option code='es' phoneCode='34' >Spain</option>" +
//		"<option code='lk' phoneCode='94' >Sri Lanka</option>" +
//		"<option code='sh' phoneCode='290' >Saint Helena, Ascension And Tristan Da Cunha</option>" +
//		"<option code='pm' phoneCode='508' >Saint Pierre And Miquelon</option>" +
//		"<option code='sd' phoneCode='249' >Sudan</option>" +
//		"<option code='sr' phoneCode='597' >Suriname</option>" +
//		"<option code='sz' phoneCode='268' >Swaziland</option>" +
//		"<option code='se' phoneCode='46' >Sweden</option>" +
//		"<option code='ch' phoneCode='41' >Switzerland</option>" +
//		"<option code='sy' phoneCode='963' >Syrian Arab Republic</option>" +
//		"<option code='tw' phoneCode='886' >Taiwan, Province Of China</option>" +
//		"<option code='tj' phoneCode='992' >Tajikistan</option>" +
//		"<option code='tz' phoneCode='255' >Tanzania, United Republic Of</option>" +
//		"<option code='th' phoneCode='66' >Thailand</option>" +
//		"<option code='tg' phoneCode='228' >Togo</option>" +
//		"<option code='tk' phoneCode='690' >Tokelau</option>" +
//		"<option code='to' phoneCode='676' >Tonga</option>" +
//		"<option code='tn' phoneCode='216' >Tunisia</option>" +
//		"<option code='tr' phoneCode='90' >Turkey</option>" +
//		"<option code='tm' phoneCode='993' >Turkmenistan</option>" +
//		"<option code='tv' phoneCode='688' >Tuvalu</option>" +
//		"<option code='ae' phoneCode='971' >United Arab Emirates</option>" +
//		"<option code='ug' phoneCode='256' >Uganda</option>" +
//		"<option code='gb' phoneCode='44' >United Kingdom</option>" +
//		"<option code='ua' phoneCode='380' >Ukraine</option>" +
//		"<option code='uy' phoneCode='598' >Uruguay</option>" +
//		"<option code='us' phoneCode='1' >United States</option>" +
//		"<option code='uz' phoneCode='998' >Uzbekistan</option>" +
//		"<option code='vu' phoneCode='678' >Vanuatu</option>" +
//		"<option code='va' phoneCode='39' >Holy See (vatican City State)</option>" +
//		"<option code='ve' phoneCode='58' >Venezuela, Bolivarian Republic Of</option>" +
//		"<option code='vn' phoneCode='84' >Viet Nam</option>" +
//		"<option code='wf' phoneCode='681' >Wallis And Futuna</option>" +
//		"<option code='ye' phoneCode='967' >Yemen</option>" +
//		"<option code='zm' phoneCode='260' >Zambia</option>" +
//		"<option code='zw' phoneCode='263' >Zimbabwe</option>";
		
		var selectValue = countrySelect.value;
		if (selectValue == null || selectValue == "") {
			selectValue = '61au';
		}
		
		countrySelect.innerHTML = options;
		
		for (var i=0; i<countrySelect.options.length; i++) {
			if (countrySelect.options[i].value == selectValue) {
				countrySelect.options[i].selected = 'selected';
			}
		}
	}
}

