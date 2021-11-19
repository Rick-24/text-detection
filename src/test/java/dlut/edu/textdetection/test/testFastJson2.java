package dlut.edu.textdetection.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import dlut.edu.textdetection.model.model.intergration.RegionResultDO;
import dlut.edu.textdetection.model.model.intergration.RuleResultDO;
import org.junit.jupiter.api.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/11/17 22:44
 */
public class testFastJson2 {
    @Test
    public void test() {
        String json ="{\n" +
                "    \"PROVINCE\": [\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区企业挂牌上市补贴专项资金管理办法.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第三条 境内首发上市（IPO）企业，按照经审核后的上市票据实际发生额给予补贴，补贴额度最高不超过300万元\",\n" +
                "                        \"duan\": \"4\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"统筹现有发展资金，对经认定的重点物流项目，按其年实际贷款额给予不超过8%的一次性贴息补助（每家企业贴息额度最高不超过200万元）\",\n" +
                "                        \"duan\": \"32\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.931859536229316,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"如果当年财政预算资金不足，不能安排应享受资金补贴的企业，可结转下年优先安排\",\n" +
                "                        \"duan\": \"22\",\n" +
                "                        \"ju\": \"2\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"七、工业项目已经享受了的优惠政策但经营期未满十年，企业应返还政府给予的补助资金方可转让土地使用权\",\n" +
                "                        \"duan\": \"17\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9122037376345133,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区应用技术研究与开发资金管理办法（修订）.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"（二）创新型企业项目按不超过项目研发投入的30%比例给予补助，单项补助最高额度原则上不超过150万元\",\n" +
                "                        \"duan\": \"36\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"统筹现有发展资金，对经认定的重点物流项目，按其年实际贷款额给予不超过8%的一次性贴息补助（每家企业贴息额度最高不超过200万元）\",\n" +
                "                        \"duan\": \"32\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9592420659066749,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"（一）重点研发及成果转化项目及重大协同创新项目，按不超过项目研发投入的30%比例给予补助，单项补助最高额度原则上不超过200万元\",\n" +
                "                        \"duan\": \"35\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"对于引进的国内外知名集成电路设计企业以及高端研发中心，给予不超过实际投资总额10%的补助，补助金额不超过6000万元\",\n" +
                "                        \"duan\": \"23\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.940496234341011,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"（三）科技型中小企业创新项目按不超过项目研发投入的30%比例给予补助，单项补助最高额度原则上不超过80万元\",\n" +
                "                        \"duan\": \"37\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"对于引进的国内外知名集成电路设计企业以及高端研发中心，给予不超过实际投资总额10%的补助，补助金额不超过6000万元\",\n" +
                "                        \"duan\": \"23\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9344714537374096,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"（二）创新型企业项目按不超过项目研发投入的30%比例给予补助，单项补助最高额度原则上不超过150万元\",\n" +
                "                        \"duan\": \"36\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"对于引进的国内外知名集成电路设计企业以及高端研发中心，给予不超过实际投资总额10%的补助，补助金额不超过6000万元\",\n" +
                "                        \"duan\": \"23\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9324602755236644,\n" +
                "                    \"keyword_match\": 4,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"（二）创新型企业项目按不超过项目研发投入的30%比例给予补助，单项补助最高额度原则上不超过150万元\",\n" +
                "                        \"duan\": \"36\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十一、根据《辽宁省首台（套）重大技术装备专项补助资金管理办法》，满足条件的企业可申请针对首台（套）重大技术装备的专项补助资金，首台（套）重大技术装备补助资金的数额按企业首台（套）重大技术装备首次销售价格的20%核定，上限不超过1600万元\",\n" +
                "                        \"duan\": \"25\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9012805489602491,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区鼓励外贸及跨境电子商务发展扶持资金暂行办法.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"根据其经营规模、入驻企业情况，给予600万元以内的运营费补贴、5年的房屋租金减免等，具体细则另行制定\",\n" +
                "                        \"duan\": \"11\",\n" +
                "                        \"ju\": \"2\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十五、鼓励物流企业将其总部设立于本区，视其运营、实现营业收入等情况给予适当补助和奖励\",\n" +
                "                        \"duan\": \"34\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9299900037309954,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"（一）鼓励企业发展进出口商品仓储物流，租赁由区商务局认定的物流园区仓储空间，给予租赁费用10%的补贴，每家企业每年最高不超过2万元，享受补贴不超过2年\",\n" +
                "                        \"duan\": \"25\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"对于引进的国内外知名集成电路设计企业以及高端研发中心，给予不超过实际投资总额10%的补助，补助金额不超过6000万元\",\n" +
                "                        \"duan\": \"23\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9199582287030948,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区推进人才资源开发十项措施（试行）.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"在连注册登记一年以上且在本区依法纳税的企业或依法设立的事业单位当年引进入选省部级及以上人才工程（项目）及相当层次的高层次人才，经相关部门认定，按每人5-10万元标准一次性给予用人单位引才资助；一次性给予个人20-40万元安家费；5年内每年给予个人4万元薪酬补贴\",\n" +
                "                        \"duan\": \"2\",\n" +
                "                        \"ju\": \"2\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十八、对新设立的外资制造业企业和现代服务业企业，根据实缴注册金额和当年营业收入给予相应的补助\",\n" +
                "                        \"duan\": \"41\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9073487141978757,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区经济工作奖励暂行办法.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第六条 对企业固定资产投资额达2000万元以上的技术改造项目，按照新设备购置费用的2%予以奖励，单个项目不超过50万元\",\n" +
                "                        \"duan\": \"48\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"统筹现有发展资金，对经认定的重点物流项目，按其年实际贷款额给予不超过8%的一次性贴息补助（每家企业贴息额度最高不超过200万元）\",\n" +
                "                        \"duan\": \"32\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.956076309284886,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第四条 对被认定大连市制造业重点领域首台（套）技术设备示范应用项目的企业或项目单位，按照市级奖励金额的10%给予奖励\",\n" +
                "                        \"duan\": \"46\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"统筹现有发展资金，对经认定的重点物流项目，按其年实际贷款额给予不超过8%的一次性贴息补助（每家企业贴息额度最高不超过200万元）\",\n" +
                "                        \"duan\": \"32\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9043776143230402,\n" +
                "                    \"keyword_match\": 4,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第十一条 对列入国家军用技术转民用推广目录项目且在我区实现产业化的重点推荐项目和推荐项目，分别给予50万元、30万元奖励；对我区企业技术与产品列入国家“民参军”技术与产业推荐目录的重点推荐项目和推荐项目，分别给予50万元、30万元奖励\",\n" +
                "                        \"duan\": \"53\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"统筹现有发展资金，对经认定的重点物流项目，按其年实际贷款额给予不超过8%的一次性贴息补助（每家企业贴息额度最高不超过200万元）\",\n" +
                "                        \"duan\": \"32\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9006011026187368,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区经济工作奖励暂行办法实施细则.docx\",\n" +
                "            \"match_list\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区促进融资租赁行业发展扶持办法.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第十条 单一企业每年享受本办法规定的各类扶持资金总额不超过500万元人民币，企业获得的资金优先奖励\",\n" +
                "                        \"duan\": \"33\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"统筹现有发展资金，对经认定的重点物流项目，按其年实际贷款额给予不超过8%的一次性贴息补助（每家企业贴息额度最高不超过200万元）\",\n" +
                "                        \"duan\": \"32\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.952478801520444,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第六条 凡在甘井子区注册的融资租赁企业，为甘井子区所属企业提供融资总额达到3000万元人民币及以上的，根据其当年为甘井子区企业提供融资总额，给予融资总额1%的补贴\",\n" +
                "                        \"duan\": \"14\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十八、对新设立的外资制造业企业和现代服务业企业，根据实缴注册金额和当年营业收入给予相应的补助\",\n" +
                "                        \"duan\": \"41\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9289019740112349,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第十条 单一企业每年享受本办法规定的各类扶持资金总额不超过500万元人民币，企业获得的资金优先奖励\",\n" +
                "                        \"duan\": \"33\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十一、根据《辽宁省首台（套）重大技术装备专项补助资金管理办法》，满足条件的企业可申请针对首台（套）重大技术装备的专项补助资金，首台（套）重大技术装备补助资金的数额按企业首台（套）重大技术装备首次销售价格的20%核定，上限不超过1600万元\",\n" +
                "                        \"duan\": \"25\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9236493027650567,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第十条 单一企业每年享受本办法规定的各类扶持资金总额不超过500万元人民币，企业获得的资金优先奖励\",\n" +
                "                        \"duan\": \"33\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"七、工业项目已经享受了的优惠政策但经营期未满十年，企业应返还政府给予的补助资金方可转让土地使用权\",\n" +
                "                        \"duan\": \"17\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9175720622187459,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第二条 本办法所称融资租赁企业，是指注册地和税管地均属大连市甘井子区，章程规定首期应缴注册资本金已足额到位，遵守国家法律法规，无企业信用不良记录，经营状况良好，并积极为甘井子区所属企业提供融资服务\",\n" +
                "                        \"duan\": \"2\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十九、对于经过认定的技术先进型服务企业，按国家规定减按15%征收企业所得税\",\n" +
                "                        \"duan\": \"43\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9077012827774174,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区支持科技创新若干规定.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第五条 对研发投入在200万元以上的重点攻关项目，按照实际研发费用支出给予最高30%补助，项目执行期内补助总额不超过150万元\",\n" +
                "                        \"duan\": \"11\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"统筹现有发展资金，对经认定的重点物流项目，按其年实际贷款额给予不超过8%的一次性贴息补助（每家企业贴息额度最高不超过200万元）\",\n" +
                "                        \"duan\": \"32\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9505945864309411,\n" +
                "                    \"keyword_match\": 4,\n" +
                "                    \"matching_degree\": \"2\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"对创新功能型平台、技术创新服务平台和专业技术服务平台为区内企业提供测试检测、合作研发、委托开发、研发设计、技术解决方案等专业技术服务的，每年根据其为区内企业提供服务实际发生的费用给予资助，对注册纳税在区内的单位给予10%、不超过100万元的资助\",\n" +
                "                        \"duan\": \"21\",\n" +
                "                        \"ju\": \"4\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"对于引进的国内外知名集成电路设计企业以及高端研发中心，给予不超过实际投资总额10%的补助，补助金额不超过6000万元\",\n" +
                "                        \"duan\": \"23\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9363844132637063,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第四条 对研发投入在600万元以上的科技重大项目，按照实际研发费用支出给予最高30%补助，项目执行期内补助总额不超过200万元\",\n" +
                "                        \"duan\": \"10\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"对于引进的国内外知名集成电路设计企业以及高端研发中心，给予不超过实际投资总额10%的补助，补助金额不超过6000万元\",\n" +
                "                        \"duan\": \"23\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9296419600813567,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第五条 对研发投入在200万元以上的重点攻关项目，按照实际研发费用支出给予最高30%补助，项目执行期内补助总额不超过150万元\",\n" +
                "                        \"duan\": \"11\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"对于引进的国内外知名集成电路设计企业以及高端研发中心，给予不超过实际投资总额10%的补助，补助金额不超过6000万元\",\n" +
                "                        \"duan\": \"23\",\n" +
                "                        \"ju\": \"3\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9289310055935982,\n" +
                "                    \"keyword_match\": 4,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"对创新功能型平台、技术创新服务平台和专业技术服务平台为区内企业提供测试检测、合作研发、委托开发、研发设计、技术解决方案等专业技术服务的，每年根据其为区内企业提供服务实际发生的费用给予资助，对注册纳税在区内的单位给予10%、不超过100万元的资助\",\n" +
                "                        \"duan\": \"21\",\n" +
                "                        \"ju\": \"4\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十九、对于经过认定的技术先进型服务企业，按国家规定减按15%征收企业所得税\",\n" +
                "                        \"duan\": \"43\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9105327865877612,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"0\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"filepath_input\": \"F:/GitRepos/text-detection/target/classes/tmp/2021-11-15/测试用招商引资政策.docx\",\n" +
                "            \"filepath_rule\": \"F:/GitRepos/text-detection/src/main/resources/static/rule/21/2/11/甘井子区总部经济扶持办法（试行）.docx\",\n" +
                "            \"match_list\": [\n" +
                "                {\n" +
                "                    \"warehouse\": {\n" +
                "                        \"sentence\": \"第十九条 本办法所称总部企业产值规模（营业收入）、形成的区级贡献以申报企业独立法人（含分支机构）及其控股50%（含）以上在本区注册的一级、二级子公司作为统计核算口径，各年度股权关系以当年12月31日股权登记状况为准\",\n" +
                "                        \"duan\": \"88\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"userinput\": {\n" +
                "                        \"sentence\": \"十八、对新设立的外资制造业企业和现代服务业企业，根据实缴注册金额和当年营业收入给予相应的补助\",\n" +
                "                        \"duan\": \"41\",\n" +
                "                        \"ju\": \"1\"\n" +
                "                    },\n" +
                "                    \"similarity\": 0.9141043358165732,\n" +
                "                    \"keyword_match\": 3,\n" +
                "                    \"matching_degree\": \"1\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        DetectionResultDO resultDO = JSON.parseObject(json, new TypeReference<DetectionResultDO>() {

        });
        System.out.println(resultDO);
    }

}
