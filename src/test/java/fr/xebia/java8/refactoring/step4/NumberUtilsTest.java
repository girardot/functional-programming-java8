package fr.xebia.java8.refactoring.step4;

import fr.xebia.java8.refactoring.step3.NumberUtils;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilsTest {

    @Test
    public void should_return_100_random_number_when_seed_is_three() {

        int[] randomValues = NumberUtils.generateRandom(100, 3L);

        assertThat(randomValues).hasSize(100);
        assertThat(randomValues).isEqualTo(new int[]{734, 660, 210, 581, 128, 202, 549, 564, 459, 961, 585, 882, 277, 614, 981, 806, 576, 137, 886, 99, 911, 92, 385, 795, 278, 913, 357, 259, 946, 793, 638, 635, 922, 768, 192, 417, 561, 134, 153, 787, 857, 89, 632, 74, 270, 142, 928, 135, 724, 414, 539, 421, 157, 589, 229, 238, 507, 246, 430, 610, 526, 425, 75, 186, 571, 687, 995, 922, 850, 709, 265, 780, 946, 395, 930, 426, 403, 593, 620, 995, 199, 983, 344, 631, 326, 882, 198, 790, 692, 671, 180, 882, 609, 56, 779, 269, 814, 843, 127, 444});

    }

    @Test
    public void should_split_even_and_odd_number() {

        int[] randomValues = NumberUtils.generateRandom(100, 3L);

        Map<Boolean, List<Integer>> evenAndOddNumbers = NumberUtils.splitEvenAndOddNumber(randomValues);

        List<Integer> evenNumber = evenAndOddNumbers.get(Boolean.TRUE);
        List<Integer> oddNumber = evenAndOddNumbers.get(Boolean.FALSE);

        assertThat(evenNumber).isEqualTo(Arrays.asList(734, 660, 210, 128, 202, 564, 882, 614, 806, 576, 886, 92, 278, 946, 638, 922, 768, 192, 134, 632, 74, 270, 142, 928, 724, 414, 238, 246, 430, 610, 526, 186, 922, 850, 780, 946, 930, 426, 620, 344, 326, 882, 198, 790, 692, 180, 882, 56, 814, 444));
        assertThat(oddNumber).isEqualTo(Arrays.asList(581, 549, 459, 961, 585, 277, 981, 137, 99, 911, 385, 795, 913, 357, 259, 793, 635, 417, 561, 153, 787, 857, 89, 135, 539, 421, 157, 589, 229, 507, 425, 75, 571, 687, 995, 709, 265, 395, 403, 593, 995, 199, 983, 631, 671, 609, 779, 269, 843, 127));

    }

    @Test
    public void should_return_45_fibonacci_number() {
        assertThat(NumberUtils.fibonacci(45)).containsExactly(1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L, 75025L, 121393L, 196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L, 3524578L, 5702887L, 9227465L, 14930352L, 24157817L, 39088169L, 63245986L, 102334155L, 165580141L, 267914296L, 433494437L, 701408733L, 1134903170L);
    }

    @Test(expected = NotImplementedException.class)
    public void should_return_infinite_stream_with_fibonacci_sequence() {
        //TODO: remove expected = NotImplementedException.class
        assertThat(NumberUtils.fibonacciStream().limit(45).collect(Collectors.toList())).containsExactly(1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L, 75025L, 121393L, 196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L, 3524578L, 5702887L, 9227465L, 14930352L, 24157817L, 39088169L, 63245986L, 102334155L, 165580141L, 267914296L, 433494437L, 701408733L, 1134903170L);
        assertThat(NumberUtils.fibonacciStream().limit(1000).collect(Collectors.toList())).containsExactly(1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L, 75025L, 121393L, 196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L, 3524578L, 5702887L, 9227465L, 14930352L, 24157817L, 39088169L, 63245986L, 102334155L, 165580141L, 267914296L, 433494437L, 701408733L, 1134903170L, 1836311903L, 2971215073L, 4807526976L, 7778742049L, 12586269025L, 20365011074L, 32951280099L, 53316291173L, 86267571272L, 139583862445L, 225851433717L, 365435296162L, 591286729879L, 956722026041L, 1548008755920L, 2504730781961L, 4052739537881L, 6557470319842L, 10610209857723L, 17167680177565L, 27777890035288L, 44945570212853L, 72723460248141L, 117669030460994L, 190392490709135L, 308061521170129L, 498454011879264L, 806515533049393L, 1304969544928657L, 2111485077978050L, 3416454622906707L, 5527939700884757L, 8944394323791464L, 14472334024676221L, 23416728348467685L, 37889062373143906L, 61305790721611591L, 99194853094755497L, 160500643816367088L, 259695496911122585L, 420196140727489673L, 679891637638612258L, 1100087778366101931L, 1779979416004714189L, 2880067194370816120L, 4660046610375530309L, 7540113804746346429L, -6246583658587674878L, 1293530146158671551L, -4953053512429003327L, -3659523366270331776L, -8612576878699335103L, 6174643828739884737L, -2437933049959450366L, 3736710778780434371L, 1298777728820984005L, 5035488507601418376L, 6334266236422402381L, -7076989329685730859L, -742723093263328478L, -7819712422949059337L, -8562435516212387815L, 2064596134548104464L, -6497839381664283351L, -4433243247116178887L, 7515661444929089378L, 3082418197812910491L, -7848664430967551747L, -4766246233154641256L, 5831833409587358613L, 1065587176432717357L, 6897420586020075970L, 7963007762452793327L, -3586315725236682319L, 4376692037216111008L, 790376311979428689L, 5167068349195539697L, 5957444661174968386L, -7322231063339043533L, -1364786402164075147L, -8687017465503118680L, 8394940206042357789L, -292077259460760891L, 8102862946581596898L, 7810785687120836007L, -2533095440007118711L, 5277690247113717296L, 2744594807106598585L, 8022285054220315881L, -7679864212382637150L, 342420841837678731L, -7337443370544958419L, -6995022528707279688L, 4114278174457313509L, -2880744354249966179L, 1233533820207347330L, -1647210534042618849L, -413676713835271519L, -2060887247877890368L, -2474563961713161887L, -4535451209591052255L, -7010015171304214142L, 6901277692814285219L, -108737478489928923L, 6792540214324356296L, 6683802735834427373L, -4970401123550767947L, 1713401612283659426L, -3256999511267108521L, -1543597898983449095L, -4800597410250557616L, -6344195309234006711L, 7301951354224987289L, 957756044990980578L, 8259707399215967867L, 9217463444206948445L, -969573230286635304L, 8247890213920313141L, 7278316983633677837L, -2920536876155560638L, 4357780107478117199L, 1437243231322556561L, 5795023338800673760L, 7232266570123230321L, -5419454164785647535L, 1812812405337582786L, -3606641759448064749L, -1793829354110481963L, -5400471113558546712L, -7194300467669028675L, 5851972492481976229L, -1342327975187052446L, 4509644517294923783L, 3167316542107871337L, 7676961059402795120L, -7602466472198885159L, 74494587203909961L, -7527971884994975198L, -7453477297791065237L, 3465294890923511181L, -3988182406867554056L, -522887515944042875L, -4511069922811596931L, -5033957438755639806L, 8901716712142314879L, 3867759273386675073L, -5677268088180561664L, -1809508814793886591L, -7486776902974448255L, 9150458355941216770L, 1663681452966768515L, -7632604264801566331L, -5968922811834797816L, 4845216997073187469L, -1123705814761610347L, 3721511182311577122L, 2597805367549966775L, 6319316549861543897L, 8917121917411510672L, -3210305606436497047L, 5706816310975013625L, 2496510704538516578L, 8203327015513530203L, -7746906353657504835L, 456420661856025368L, -7290485691801479467L, -6834065029945454099L, 4322193351962618050L, -2511871677982836049L, 1810321673979782001L, -701550004003054048L, 1108771669976727953L, 407221665973673905L, 1515993335950401858L, 1923215001924075763L, 3439208337874477621L, 5362423339798553384L, 8801631677673031005L, -4282689056237967227L, 4518942621435063778L, 236253565197096551L, 4755196186632160329L, 4991449751829256880L, -8700098135248134407L, -3708648383418877527L, 6037997555042539682L, 2329349171623662155L, 8367346726666201837L, -7750048175419687624L, 617298551246514213L, -7132749624173173411L, -6515451072926659198L, 4798543376609719007L, -1716907696316940191L, 3081635680292778816L, 1364727983975838625L, 4446363664268617441L, 5811091648244456066L, -8189288761196478109L, -2378197112952022043L, 7879258199561051464L, 5501061086609029421L, -5066424787539470731L, 434636299069558690L, -4631788488469912041L, -4197152189400353351L, -8828940677870265392L, 5420651206438932873L, -3408289471431332519L, 2012361735007600354L, -1395927736423732165L, 616433998583868189L, -779493737839863976L, -163059739255995787L, -942553477095859763L, -1105613216351855550L, -2048166693447715313L, -3153779909799570863L, -5201946603247286176L, -8355726513046857039L, 4889070957415408401L, -3466655555631448638L, 1422415401783959763L, -2044240153847488875L, -621824752063529112L, -2666064905911017987L, -3287889657974547099L, -5953954563885565086L, 9204899851849439431L, 3250945287963874345L, -5990898933896237840L, -2739953645932363495L, -8730852579828601335L, 6975937847948586786L, -1754914731880014549L, 5221023116068572237L, 3466108384188557688L, 8687131500257129925L, -6293504189263864003L, 2393627310993265922L, -3899876878270598081L, -1506249567277332159L, -5406126445547930240L, -6912376012825262399L, 6128241615336358977L, -784134397488903422L, 5344107217847455555L, 4559972820358552133L, -8542664035503543928L, -3982691215144991795L, 5921388823061015893L, 1938697607916024098L, 7860086430977039991L, -8647960034816487527L, -787873603839447536L, 9010910435053616553L, 8223036831214169017L, -1212796807441766046L, 7010240023772402971L, 5797443216330636925L, -5639060833606511720L, 158382382724125205L, -5480678450882386515L, -5322296068158261310L, 7643769554668903791L, 2321473486510642481L, -8481501032530005344L, -6160027546019362863L, 3805215495160183409L, -2354812050859179454L, 1450403444301003955L, -904408606558175499L, 545994837742828456L, -358413768815347043L, 187581068927481413L, -170832699887865630L, 16748369039615783L, -154084330848249847L, -137335961808634064L, -291420292656883911L, -428756254465517975L, -720176547122401886L, -1148932801587919861L, -1869109348710321747L, -3018042150298241608L, -4887151499008563355L, -7905193649306804963L, 5654398925394183298L, -2250794723912621665L, 3403604201481561633L, 1152809477568939968L, 4556413679050501601L, 5709223156619441569L, -8181107238039608446L, -2471884081420166877L, 7793752754249776293L, 5321868672829609416L, -5331122646630165907L, -9253973800556491L, -5340376620430722398L, -5349630594231278889L, 7756736859047550329L, 2407106264816271440L, -8282900949845729847L, -5875794685029458407L, 4288048438834363362L, -1587746246195095045L, 2700302192639268317L, 1112555946444173272L, 3812858139083441589L, 4925414085527614861L, 8738272224611056450L, -4783057763570880305L, 3955214461040176145L, -827843302530704160L, 3127371158509471985L, 2299527855978767825L, 5426899014488239810L, 7726426870467007635L, -5293418188754304171L, 2433008681712703464L, -2860409507041600707L, -427400825328897243L, -3287810332370497950L, -3715211157699395193L, -7003021490069893143L, 7728511425940263280L, 725489935870370137L, 8454001361810633417L, 9179491297681003554L, -813251414217914645L, 8366239883463088909L, 7552988469245174264L, -2527515721001288443L, 5025472748243885821L, 2497957027242597378L, 7523429775486483199L, -8425357270980471039L, -901927495493987840L, 9119459307235092737L, 8217531811741104897L, -1109752954733353982L, 7107778857007750915L, 5998025902274396933L, -5340939314427403768L, 657086587846993165L, -4683852726580410603L, -4026766138733417438L, -8710618865313828041L, 5709359069662306137L, -3001259795651521904L, 2708099274010784233L, -293160521640737671L, 2414938752370046562L, 2121778230729308891L, 4536716983099355453L, 6658495213828664344L, -7251531876781531819L, -593036662952867475L, -7844568539734399294L, -8437605202687266769L, 2164570331287885553L, -6273034871399381216L, -4108464540111495663L, 8065244662198674737L, 3956780122087179074L, -6424719289423697805L, -2467939167336518731L, -8892658456760216536L, 7086146449612816349L, -1806512007147400187L, 5279634442465416162L, 3473122435318015975L, 8752756877783432137L, -6220864760608103504L, 2531892117175328633L, -3688972643432774871L, -1157080526257446238L, -4846053169690221109L, -6003133695947667347L, 7597557208071663160L, 1594423512123995813L, 9191980720195658973L, -7660339841389896830L, 1531640878805762143L, -6128698962584134687L, -4597058083778372544L, 7720987027347044385L, 3123928943568671841L, -7601828102793835390L, -4477899159225163549L, 6367016811690552677L, 1889117652465389128L, 8256134464155941805L, -8301491957088220683L, -45357492932278878L, -8346849450020499561L, -8392206942952778439L, 1707687680736273616L, -6684519262216504823L, -4976831581480231207L, 6785393230012815586L, 1808561648532584379L, 8593954878545399965L, -8044227546631567272L, 549727331913832693L, -7494500214717734579L, -6944772882803901886L, 4007470976187915151L, -2937301906615986735L, 1070169069571928416L, -1867132837044058319L, -796963767472129903L, -2664096604516188222L, -3461060371988318125L, -6125156976504506347L, 8860526725216727144L, 2735369748712220797L, -6850847599780603675L, -4115477851068382878L, 7480418622860565063L, 3364940771792182185L, -7601384679056804368L, -4236443907264622183L, 6608915487388125065L, 2372471580123502882L, 8981387067511627947L, -7092885426074420787L, 1888501641437207160L, -5204383784637213627L, -3315882143200006467L, -8520265927837220094L, 6610596002672325055L, -1909669925164895039L, 4700926077507430016L, 2791256152342534977L, 7492182229849964993L, -8163305691517051646L, -671123461667086653L, -8834429153184138299L, 8941191458858326664L, 106762305674188365L, 9047953764532515029L, 9154716070206703394L, -244074238970333193L, 8910641831236370201L, 8666567592266037008L, -869534650207144407L, 7797032942058892601L, 6927498291851748194L, -3722212839798910821L, 3205285452052837373L, -516927387746073448L, 2688358064306763925L, 2171430676560690477L, 4859788740867454402L, 7031219417428144879L, -6555735915413952335L, 475483502014192544L, -6080252413399759791L, -5604768911385567247L, 6761722748924224578L, 1156953837538657331L, 7918676586462881909L, 9075630424001539240L, -1452437063245130467L, 7623193360756408773L, 6170756297511278306L, -4652794415441864537L, 1517961882069413769L, -3134832533372450768L, -1616870651303036999L, -4751703184675487767L, -6368573835978524766L, 7326467053055539083L, 957893217077014317L, 8284360270132553400L, -9204490586499983899L, -920130316367430499L, 8322123170842137218L, 7401992854474706719L, -2722628048392707679L, 4679364806081999040L, 1956736757689291361L, 6636101563771290401L, 8592838321460581762L, -3217804188477679453L, 5375034132982902309L, 2157229944505222856L, 7532264077488125165L, -8757250051716203595L, -1224985974228078430L, 8464508047765269591L, 7239522073537191161L, -2742713952407090864L, 4496808121130100297L, 1754094168723009433L, 6250902289853109730L, 8004996458576119163L, -4190845325280322723L, 3814151133295796440L, -376694191984526283L, 3437456941311270157L, 3060762749326743874L, 6498219690638014031L, -8887761633744793711L, -2389541943106779680L, 7169440496857978225L, 4779898553751198545L, -6497405023100374846L, -1717506469349176301L, -8214911492449551147L, 8514326111910824168L, 299414619461273021L, 8813740731372097189L, 9113155350833370210L, -519847991504084217L, 8593307359329285993L, 8073459367825201776L, -1779977346555063847L, 6293482021270137929L, 4513504674715074082L, -7639757377724339605L, -3126252703009265523L, 7680733992975946488L, 4554481289966680965L, -6211528790766924163L, -1657047500800243198L, -7868576291567167361L, 8921120281342141057L, 1052543989774973696L, -8473079802592436863L, -7420535812817463167L, 2553128458299651586L, -4867407354517811581L, -2314278896218159995L, -7181686250735971576L, 8950778926755420045L, 1769092676019448469L, -7726872470934683102L, -5957779794915234633L, 4762091807859633881L, -1195687987055600752L, 3566403820804033129L, 2370715833748432377L, 5937119654552465506L, 8307835488300897883L, -4201788930856188227L, 4106046557444709656L, -95742373411478571L, 4010304184033231085L, 3914561810621752514L, 7924865994654983599L, -6607316268432815503L, 1317549726222168096L, -5289766542210647407L, -3972216815988479311L, 9184760715510424898L, 5212543899521945587L, -4049439458677181131L, 1163104440844764456L, -2886335017832416675L, -1723230576987652219L, -4609565594820068894L, -6332796171807721113L, 7504382307081761609L, 1171586135274040496L, 8675968442355802105L, -8599189496079709015L, 76778946276093090L, -8522410549803615925L, -8445631603527522835L, 1478701920378412856L, -6966929683149109979L, -5488227762770697123L, 5991586627789744514L, 503358865019047391L, 6494945492808791905L, 6998304357827839296L, -4953494223072920415L, 2044810134754918881L, -2908684088318001534L, -863873953563082653L, -3772558041881084187L, -4636431995444166840L, -8408990037325251027L, 5401322040940133749L, -3007667996385117278L, 2393654044555016471L, -614013951830100807L, 1779640092724915664L, 1165626140894814857L, 2945266233619730521L, 4110892374514545378L, 7056158608134275899L, -7279693091060730339L, -223534482926454440L, -7503227573987184779L, -7726762056913639219L, 3216754442808727618L, -4510007614104911601L, -1293253171296183983L, -5803260785401095584L, -7096513956697279567L, 5546969331611176465L, -1549544625086103102L, 3997424706525073363L, 2447880081438970261L, 6445304787964043624L, 8893184869403013885L, -3108254416342494107L, 5784930453060519778L, 2676676036718025671L, 8461606489778545449L, -7308461547212980496L, 1153144942565564953L, -6155316604647415543L, -5002171662081850590L, 7289255806980285483L, 2287084144898434893L, -8870404121830831240L, -6583319976932396347L, 2993019974946324029L, -3590300001986072318L, -597280027039748289L, -4187580029025820607L, -4784860056065568896L, -8972440085091389503L, 4689443932552593217L, -4282996152538796286L, 406447780013796931L, -3876548372524999355L, -3470100592511202424L, -7346648965036201779L, 7629994516162147413L, 283345551125945634L, 7913340067288093047L, 8196685618414038681L, -2336718388007419888L, 5859967230406618793L, 3523248842399198905L, -9063528000903733918L, -5540279158504535013L, 3842936914301282685L, -1697342244203252328L, 2145594670098030357L, 448252425894778029L, 2593847095992808386L, 3042099521887586415L, 5635946617880394801L, 8678046139767981216L, -4132751316061175599L, 4545294823706805617L, 412543507645630018L, 4957838331352435635L, 5370381838998065653L, -8118523903359050328L, -2748142064360984675L, 7580078105989516613L, 4831936041628531938L, -6034729926091503065L, -1202793884462971127L, -7237523810554474192L, -8440317695017445319L, 2768902568137632105L, -5671415126879813214L, -2902512558742181109L, -8573927685621994323L, 6970303829345376184L, -1603623856276618139L, 5366679973068758045L, 3763056116792139906L, 9129736089860897951L, -5553951867056513759L, 3575784222804384192L, -1978167644252129567L, 1597616578552254625L, -380551065699874942L, 1217065512852379683L, 836514447152504741L, 2053579960004884424L, 2890094407157389165L, 4943674367162273589L, 7833768774319662754L, -5669300932227615273L, 2164467842092047481L, -3504833090135567792L, -1340365248043520311L, -4845198338179088103L, -6185563586222608414L, 7415982149307855099L, 1230418563085246685L, 8646400712393101784L, -8569924798231203147L, 76475914161898637L, -8493448884069304510L, -8416972969907405873L, 1536322219732841233L, -6880650750174564640L, -5344328530441723407L, 6221764793093263569L, 877436262651540162L, 7099201055744803731L, 7976637318396343893L, -3370905699568403992L, 4605731618827939901L, 1234825919259535909L, 5840557538087475810L, 7075383457347011719L, -5530803078275064087L, 1544580379071947632L, -3986222699203116455L, -2441642320131168823L, -6427865019334285278L, -8869507339465454101L, 3149371714909812237L, -5720135624555641864L, -2570763909645829627L, -8290899534201471491L, 7585080629862250498L, -705818904339220993L, 6879261725523029505L, 6173442821183808512L, -5394039527002713599L, 779403294181094913L, -4614636232821618686L, -3835232938640523773L, -8449869171462142459L, 6161641963606885384L, -2288227207855257075L, 3873414755751628309L, 1585187547896371234L, 5458602303647999543L, 7043789851544370777L, -5944351918517181296L, 1099437933027189481L, -4844913985489991815L, -3745476052462802334L, -8590390037952794149L, 6110877983293955133L, -2479512054658839016L, 3631365928635116117L, 1151853873976277101L, 4783219802611393218L, 5935073676587670319L, -7728450594510488079L, -1793376917922817760L, 8924916561276245777L, 7131539643353428017L, -2390287869079877822L, 4741251774273550195L, 2350963905193672373L, 7092215679467222568L, -9003564489048656675L, -1911348809581434107L, 7531830775079460834L, 5620481965498026727L, -5294431333132064055L, 326050632365962672L, -4968380700766101383L, -4642330068400138711L, 8836033304543311522L, 4193703236143172811L, -5417007533023067283L, -1223304296879894472L, -6640311829902961755L, -7863616126782856227L, 3942816117023733634L, -3920800009759122593L, 22016107264611041L, -3898783902494511552L, -3876767795229900511L, -7775551697724412063L, 6794424580755239042L, -981127116969173021L, 5813297463786066021L, 4832170346816893000L, -7801276263106592595L, -2969105916289699595L, 7676361894313259426L, 4707255978023559831L, -6063126201372732359L, -1355870223349172528L, -7418996424721904887L, -8774866648071077415L, 2252881000916569314L, -6521985647154508101L, -4269104646237938787L, 7655653780317104728L, 3386549134079165941L, -7404541159313280947L, -4017992025234115006L, 7024210889162155663L, 3006218863928040657L, -8416314320619355296L, -5410095456691314639L, 4620334296398881681L, -789761160292432958L, 3830573136106448723L, 3040811975814015765L, 6871385111920464488L, -8534546985975071363L, -1663161874054606875L, 8249035213679873378L, 6585873339625266503L, -3611835520404411735L, 2974037819220854768L, -637797701183556967L, 2336240118037297801L, 1698442416853740834L, 4034682534891038635L, 5733124951744779469L, -8678936587073733512L, -2945811635328954043L, 6821995851306864061L, 3876184215977910018L, -7748564006424777537L, -3872379790446867519L, 6825800276837906560L, 2953420486391039041L, -8667523310480606015L, -5714102824089566974L, 4065117939139378627L, -1648984884950188347L, 2416133054189190280L, 767148169239001933L, 3183281223428192213L, 3950429392667194146L, 7133710616095386359L, -7362604064946971111L, -228893448851584752L, -7591497513798555863L, -7820390962650140615L, 3034855597260855138L, -4785535365389285477L, -1750679768128430339L, -6536215133517715816L, -8286894901646146155L, 3623634038545689645L, -4663260863100456510L, -1039626824554766865L, -5702887687655223375L, -6742514512209990240L, 6001341873844338001L, -741172638365652239L, 5260169235478685762L, 4518996597113033523L, -8667578241117832331L, -4148581644004798808L, 5630584188586920477L, 1482002544582121669L, 7112586733169042146L, 8594589277751163815L, -2739568062789345655L, 5855021214961818160L, 3115453152172472505L, 8970474367134290665L, -6360816554402788446L, 2609657812731502219L, -3751158741671286227L, -1141500928939784008L, -4892659670611070235L, -6034160599550854243L, 7519923803547627138L, 1485763203996772895L, 9005687007544400033L, -7955293862168378688L, 1050393145376021345L, -6904900716792357343L, -5854507571416335998L, 5687335785500858275L, -167171785915477723L, 5520163999585380552L, 5352992213669902829L, -7573587860454268235L, -2220595646784365406L, 8652560566470917975L, 6431964919686552569L, -3362218587552081072L, 3069746332134471497L, -292472255417609575L, 2777274076716861922L, 2484801821299252347L, 5262075898016114269L, 7746877719315366616L, -5437790456378070731L, 2309087262937295885L, -3128703193440774846L, -819615930503478961L, -3948319123944253807L, -4767935054447732768L, -8716254178391986575L, 4962554840869832273L, -3753699337522154302L, 1208855503347677971L, -2544843834174476331L, -1335988330826798360L, -3880832165001274691L, -5216820495828073051L, -9097652660829347742L, 4132270917052130823L, -4965381743777216919L, -833110826725086096L, -5798492570502303015L, -6631603397227389111L, 6016648105979859490L, -614955291247529621L, 5401692814732329869L, 4786737523484800248L, -8258313735492421499L, -3471576212007621251L, 6716854126209508866L, 3245277914201887615L, -8484612033298155135L, -5239334119096267520L, 4722797921315128961L, -516536197781138559L, 4206261723533990402L, 3689725525752851843L, 7895987249286842245L, -6861031298669857528L, 1034955950616984717L, -5826075348052872811L, -4791119397435888094L, 7829549328220790711L, 3038429930784902617L, -7578764814703858288L, -4540334883918955671L, 6327644375086737657L, 1787309491167781986L, 8114953866254519643L, -8544480716287249987L, -429526850032730344L, -8974007566319980331L, 9043209657356840941L, 69202091036860610L, 9112411748393701551L, 9181613839430562161L, -152718485885287904L, 9028895353545274257L, 8876176867659986353L, -541671852504291006L, 8334505015155695347L, 7792833162651404341L, -2319405895902451928L, 5473427266748952413L, 3154021370846500485L, 8627448637595452898L, -6665274065267598233L, 1962174572327854665L, -4703099492939743568L, -2740924920611888903L, -7444024413551632471L, 8261794739546030242L, 817770325994397771L);
    }
}
