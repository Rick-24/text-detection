package dlut.edu.textdetection.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import dlut.edu.textdetection.model.model.intergration.DetectionResultDO;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : hongwei.zhw
 * @create 2021/10/28 13:29
 */
public class testFastJson {
    @Test
    public void testFastJsonParse() {
        String json = "[{'warehouse': {'sentence': '对年度实现规模以上工业总产值在全区排前五名的街道，分别奖励50万元、40万元、30万元、20万元、10万元',\n" +
                "   'keywords': ['工业', '总产值', '规模', '实现', '全区', '街道', '年度', '奖励'],\n" +
                "   'zhang': '第五章',\n" +
                "   'tiao': '第四条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 5,\n" +
                "  'matching_degree': 2},\n" +
                " {'warehouse': {'sentence': '物流企业被新评定为国家5A级、4A级、3A级（不含分支机构）的，分别给予50万元、40万元、30万元奖励，如果晋级，按照以上奖励金额给予补差奖励',\n" +
                "   'keywords': ['奖励', '评定', '物流', '企业', '金额', '补差', '给予', '国家'],\n" +
                "   'zhang': '第六章',\n" +
                "   'tiao': '第十五条'},\n" +
                "  'userinput': {'sentence': '被评为国家3A-5A级的企业，分别给予10、20、30万元奖励（各层奖励只补差，不累加）',\n" +
                "   'keywords': ['奖励', '补差', '评为', '给予', '国家', '企业', '累加'],\n" +
                "   'number': 1},\n" +
                "  'match_count': 5,\n" +
                "  'matching_degree': 2},\n" +
                " {'warehouse': {'sentence': '产品被评为国家驰名商标、名牌产品的，一次性奖励企业10万元；产品被评为省级著名商标、名牌产品、省长质量奖的，一次性奖励企业5万元；产品被评为市级著名商标、名牌产品、省长质量奖的，一次性奖励企业1万元',\n" +
                "   'keywords': ['名牌产品',\n" +
                "    '评为',\n" +
                "    '产品',\n" +
                "    '著名商标',\n" +
                "    '奖励',\n" +
                "    '质量奖',\n" +
                "    '省长',\n" +
                "    '企业',\n" +
                "    '市级',\n" +
                "    '国家'],\n" +
                "   'zhang': '第六章',\n" +
                "   'tiao': '第十四条'},\n" +
                "  'userinput': {'sentence': '被评为国家3A-5A级的企业，分别给予10、20、30万元奖励（各层奖励只补差，不累加）',\n" +
                "   'keywords': ['奖励', '补差', '评为', '给予', '国家', '企业', '累加'],\n" +
                "   'number': 1},\n" +
                "  'match_count': 4,\n" +
                "  'matching_degree': 1},\n" +
                " {'warehouse': {'sentence': '对年度固定资产投资在全区排前三名且完成年度计划的城市街道，分别奖励50万元、40万元、30万元；对年度固定资产投资在全区排前两名且完成年度计划的涉农街道，分别奖励50万元、40万元',\n" +
                "   'keywords': ['街道', '完成', '全区', '年度计划', '投资', '年度', '奖励', '涉农', '城市'],\n" +
                "   'zhang': '第四章',\n" +
                "   'tiao': '第一条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0},\n" +
                " {'warehouse': {'sentence': '对年度财政收入总量在全区排前三名的城市街道，分别奖励50万元、40万元、30万元；对年度财政收入总量在全区排前两名的涉农街道，分别奖励50万元、40万元',\n" +
                "   'keywords': ['全区', '财政收入', '总量', '年度', '街道', '奖励', '涉农', '城市'],\n" +
                "   'zhang': '第五章',\n" +
                "   'tiao': '第一条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0},\n" +
                " {'warehouse': {'sentence': '对年度实现社会消费品零售总额在全区排前五名的街道，分别奖励50万元、40万元、30万元、20万元、10万元',\n" +
                "   'keywords': ['零售总额', '社会', '消费品', '全区', '年度', '实现', '街道', '奖励'],\n" +
                "   'zhang': '第五章',\n" +
                "   'tiao': '第五条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0},\n" +
                " {'warehouse': {'sentence': '对年度实现规模以上工业总产值超过亿元，且增幅达到20%以上的企业，按照产值排名全区前五名的，分别奖励10万元',\n" +
                "   'keywords': ['规模', '工业', '排名', '产值', '超过', '总产值', '实现', '增幅', '企业', '全区'],\n" +
                "   'zhang': '第五章',\n" +
                "   'tiao': '第八条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0},\n" +
                " {'warehouse': {'sentence': '对年度规模以上工业总产值首次超过50亿元、30亿元、10亿元的企业，分别奖励100万元、50万元、20万元',\n" +
                "   'keywords': ['总产值', '工业', '奖励', '企业', '规模', '年度', '超过'],\n" +
                "   'zhang': '第五章',\n" +
                "   'tiao': '第九条'},\n" +
                "  'userinput': {'sentence': '每年工业总产值在全区排前二十名的街道，分别奖励50万元、30万元、20万元',\n" +
                "   'keywords': ['全区', '街道', '总产值', '工业', '奖励'],\n" +
                "   'number': 2},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0},\n" +
                " {'warehouse': {'sentence': '首次认定为国家高新技术企业的单位一次性奖励10万元，到期通过重新认定的单位一次性奖励5万元',\n" +
                "   'keywords': ['单位', '认定', '企业', '高新技术', '国家', '奖励'],\n" +
                "   'zhang': '第六章',\n" +
                "   'tiao': '第二条'},\n" +
                "  'userinput': {'sentence': '被评为国家3A-5A级的企业，分别给予10、20、30万元奖励（各层奖励只补差，不累加）',\n" +
                "   'keywords': ['奖励', '补差', '评为', '给予', '国家', '企业', '累加'],\n" +
                "   'number': 1},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0},\n" +
                " {'warehouse': {'sentence': '对新认定为国家级、省级、市级双创平台（众创空间、孵化器、加速器）的，分别给予50万元、20万元、10万元奖励；如果晋级，按照以上奖励金额给予补差奖励',\n" +
                "   'keywords': ['奖励', '空间', '平台', '双创', '众创', '市级', '金额', '补差', '给予', '加速器'],\n" +
                "   'zhang': '第六章',\n" +
                "   'tiao': '第十二条'},\n" +
                "  'userinput': {'sentence': '被评为国家3A-5A级的企业，分别给予10、20、30万元奖励（各层奖励只补差，不累加）',\n" +
                "   'keywords': ['奖励', '补差', '评为', '给予', '国家', '企业', '累加'],\n" +
                "   'number': 1},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0},\n" +
                " {'warehouse': {'sentence': '对主持或参与制定国际标准的企业或项目单位给予50万元奖励；对主持制定国家标准的企业或项目单位给予30万奖励，对参与制定的企业或项目单位给予10万元奖励；对主持制定行业标准的企业或项目单位给予20万元奖励，对参与制定的企业或项目单位给予5万元奖励',\n" +
                "   'keywords': ['企业',\n" +
                "    '制定',\n" +
                "    '项目',\n" +
                "    '给予',\n" +
                "    '单位',\n" +
                "    '奖励',\n" +
                "    '主持',\n" +
                "    '参与',\n" +
                "    '国际标准',\n" +
                "    '国家标准'],\n" +
                "   'zhang': '第六章',\n" +
                "   'tiao': '第十三条'},\n" +
                "  'userinput': {'sentence': '被评为国家3A-5A级的企业，分别给予10、20、30万元奖励（各层奖励只补差，不累加）',\n" +
                "   'keywords': ['奖励', '补差', '评为', '给予', '国家', '企业', '累加'],\n" +
                "   'number': 1},\n" +
                "  'match_count': 3,\n" +
                "  'matching_degree': 0}]";

        List<DetectionResultDO> detectionResultDOS = JSON.parseObject(json, new TypeReference<List<DetectionResultDO>>() {
        });

        System.out.println(detectionResultDOS);
    }
}
