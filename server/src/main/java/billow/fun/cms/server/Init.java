package billow.fun.cms.server;

import billow.fun.cms.server.model.Post;
import billow.fun.cms.server.model.PostRepo;
import billow.fun.cms.server.service.StorageService;
import com.sun.tools.javac.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Init {
    @Bean
    CommandLineRunner initStore(StorageService storageService,
                                PostRepo postRepo) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
            postRepo.saveAll(List.of(
                    new Post("实验室秘书—陈志军", "实验室秘书—陈志军\n" +
                            "\n" +
                            "\n" +
                            "职称/职务：初级实验师，实验室秘书\n" +
                            "\n" +
                            "学历/学位：研究生/硕士  \n" +
                            "\n" +
                            "主要研究方向：非织造材料科学与工程，纺织材料与纺织品设计，高分子材料\n" +
                            "\n" +
                            "主讲课程： 非织造材料成型加工技术(实验) \n" +
                            "\n" +
                            "主要教学与科学研究成果：\n" +
                            "\n" +
                            "    发表多篇学术论文，其中SCI 3篇、中文核心3篇，参与起草1项行业标准，拥有国家专利多项。\n" +
                            "\n", "team", new String[]{}),
                    new Post("关于开展实验室危险废物自查登记的通知", "各二级科研、教学部门：\n" +
                            "\n" +
                            "    为了加强实验室危险废弃物管理，进一步全面掌握我校危险废物种类、年产量、储存及排放情况等，推进危险废物申报工作，现特就实验室危险废弃物自查登记相关事宜通知如下：\n" +
                            "\n" +
                            "1、请各产生、储存危险废物的相关部门，根据《国家危险废物名录》（详见附件1）涉及的危险废物，对本部门危险废物情况进行详细排查、摸清底数。\n" +
                            "\n" +
                            "2、根据排查结果，涉及危险废物的部门，按照《武汉纺织大学危险废物申报登记表》（详见附件2）要求，对本单位危险废物情况认真填报。\n" +
                            "\n" +
                            "3、《武汉纺织大学危险废物申报登记表》提交时间：2015年3月23日前，纸质版单位分管领导签字，加盖公章后交资产处。电子版提交至（652518720@qq.com）邮箱.\n" +
                            "\n" +
                            "4、对自查危险废物存放安全隐患，请于2015年3月23日前将需要亟待解决的问题报资产处汇总后报学校统一研究解决。\n" +
                            "\n" +
                            "附件1：《国家危险废物名录》\n" +
                            "\n" +
                            "附件2：《武汉纺织大学危险废物申报登记表》\n" +
                            "\n" +
                            "资产与实验室管理处\n" +
                            "\n" +
                            "2015年3月17日", "notify", new String[]{}),
                    new Post("热重分析仪(TG)", "仪器型号:TG-209F1\n" +
                            "\n" +
                            "\n" +
                            "生产厂家:德国耐驰\n" +
                            "\n" +
                            "\n" +
                            "主要配置:恒温水浴;双温控制器;热红联用接口;主机\n" +
                            "\n" +
                            "\n" +
                            "主要技术指标:\n" +
                            "\n" +
                            "\n" +
                            "天平灵敏度 0.1ug;\n" +
                            "\n" +
                            "\n" +
                            "天平量程:2000mg;\n" +
                            "\n" +
                            "\n" +
                            "温度范围:室温-1000℃;\n" +
                            "\n" +
                            "\n" +
                            "加热速率:0.001-100℃/min  \n" +
                            "\n" +
                            "主要用途:\n" +
                            "\n" +
                            "\n" +
                            "测量与研究材料的如下特性:热分解性、分解过程、吸附与解吸、成分的定量分析、水分与挥发物分解过程、氧化与还原、添加剂与填充剂影响、反应的动力学。\n" +
                            "\n" +
                            "   ", "instrument", new String[]{}),
                    new Post("澳大利亚棉花公司阿伦先生访问我校", "澳大利亚棉花公司阿伦先生访问我校\n" +
                            "\n" +
                            "    5月13日上午，澳大利亚棉花公司负责人阿伦先生受王训该院长邀请访问我校，受到了副校长黄运平亲切接见，并考查我校国际合作项目“澳棉高支精纺纱线新技术研究”项目进展情况。\n" +
                            "\n" +
                            "        \n" +
                            "\n" +
                            "     阿伦先生深入纺织学院实验室，与“澳棉高支精纺纱线新技术研究”项目负责人、学院分党委书记张尚勇及课题组成员详细交流、了解项目进展情况，并查看了该项目拥有的目前最新纺纱技术纺制的高支澳棉纱线。随后学院实验室主任陈军等教师向阿伦先生介绍了纺织学院主要仪器设备和实验室承担的重大科研项目情况。\n" +
                            "\n" +
                            "     阿伦先生对“澳棉高支精纺纱线新技术研究”项目进展情况表示非常满意，高度赞扬了我校实验室建设取得的成效，并与王训该院长和张尚勇书记就下一步项目合作展开了深入座谈。\n" +
                            "\n" +
                            "     据悉，纺织学院承担的国际合作项目“澳棉高支精纺纱线新技术研究”由澳大利亚棉花公司资助，澳大利亚迪肯大学、CSRIO研究所和我校三方共同承担研究，纺织学院获项目经费近百万人民币。", "exchange", new String[]{}),
                    new Post("科研成果—论文", "科研成果—论文\n" +
                            "\n" +
                            "序号\n" +
                            "\n" +
                            "成 果 名 称\n" +
                            "\n" +
                            "完成人\n" +
                            "\n" +
                            "时间\n" +
                            "\n" +
                            "1\n" +
                            "\n" +
                            "Study on the Bending Fatigue Behavior of Single Aramid\n" +
                            "\n" +
                            "Fibers by a Novel Bending Fatigue Test Method\n" +
                            "\n" +
                            "蔡光明\n" +
                            "\n" +
                            "Journal of Fiber Bioengineering and Informatics, 2014.7(1)13-22\n" +
                            "\n" +
                            "2\n" +
                            "\n" +
                            "In-situ synthesis of gold nanoparticles for multifunctionalization of silk fabrics\n" +
                            "\n" +
                            "唐彬\n" +
                            "\n" +
                            "Dyes and Pigments, 2014, Vol.103\n" +
                            "\n" +
                            "3\n" +
                            "\n" +
                            "Growth of primary hippocampal neurons on multichannel silk fibroin scaffold\n" +
                            "\n" +
                            "张强\n" +
                            "\n" +
                            "Fibers and Polymers, 2014,15,41-46\n" +
                            "\n" +
                            "4\n" +
                            "\n" +
                            "Effective removal of dyes from aqueous solution using ultrafine silk fibroin powder\n" +
                            "\n" +
                            "肖仕丽\n" +
                            "\n" +
                            "Advanced Powder Technology, 2014,No.1，574-581\n" +
                            "\n" +
                            "5\n" +
                            "\n" +
                            "Studied on kinetic and thermodynamic parameters of natural dye curcumin on PLA fibre\n" +
                            "\n" +
                            "吴济宏\n" +
                            "\n" +
                            "Indian Journal of Fibre & Textile Research, 2013，Vol.38,pp424-426\n" +
                            "\n" +
                            "6\n" +
                            "\n" +
                            "A novel heparin release system based on blends of biomedical polyurethane and native silk fibroin powder\n" +
                            "\n" +
                            "杨红军\n" +
                            "\n" +
                            "(1/4)\n" +
                            "\n" +
                            "Journal of Controlled Release, \n" +
                            "\n" +
                            "152（2011）. 106-108. \n" +
                            "\n" +
                            "ISSN:0168-3659 影响因子：7.705\n" +
                            "\n" +
                            "7\n" +
                            "\n" +
                            "Self-assembled hairy ball-like Co3O4 nanostructures for lithium ion batteries\n" +
                            "\n" +
                            "方东\n" +
                            "\n" +
                            "（1/12）\n" +
                            "\n" +
                            "Journal of Materials Chemistry A，1（2013）, 13203-13208\n" +
                            "\n" +
                            "ISSN:0510-5842影响因子：7.443\n" +
                            "\n" +
                            "8\n" +
                            "\n" +
                            "Highly efficient light harvesting ruthenium sensitizers for dye-sensitized solar cells featuring triphenylamine donor antennas\n" +
                            "\n" +
                            "许杰\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "Journal Materials Chemistry A, 2（2014）: 4945-4953\n" +
                            "\n" +
                            "ISSN:0510-5842影响因子：7.443\n" +
                            "\n" +
                            "9\n" +
                            "\n" +
                            "Stretchable Conductive Polypyrrole/\n" +
                            "\n" +
                            "Polyurethane (PPy/PU) Strain\n" +
                            "\n" +
                            "Sensor with Netlike Microcracks for Human Breath Detection\n" +
                            "\n" +
                            "李沐芳\n" +
                            "\n" +
                            "（1/5）\n" +
                            "\n" +
                            "ACS Appllied Materials and Interfaces，24（2013）,70-74\n" +
                            "\n" +
                            "ISSN：1944-8244影响因子：6.723\n" +
                            "\n" +
                            "10\n" +
                            "\n" +
                            "A flexible polypyrrole-coated fabric counter electrode for dye-sensitized solar cells\n" +
                            "\n" +
                            "许杰\n" +
                            "\n" +
                            "（1/10）\n" +
                            "\n" +
                            "Journal of Power Sources, 257（2014）: 230-236\n" +
                            "\n" +
                            "ISSN：0378-7753影响因子：6.217\n" +
                            "\n" +
                            "11\n" +
                            "\n" +
                            "A novel hierarchically structured and highly hydrophilic poly(vinyl alcohol-co-ethylene)/poly(ethylene terephthalate) nanoporous membrane for lithium-ion battery separator\n" +
                            "\n" +
                            "王栋\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "Journal of Power Sources, 257（2014）: 230-236\n" +
                            "\n" +
                            "ISSN：0378-7753影响因子：6.217\n" +
                            "\n" +
                            "12\n" +
                            "\n" +
                            "Nanocomposite membranes based on quaternized polysulfone and functionalized montmorillonite for anion-exchange membranes\n" +
                            "\n" +
                            "张宏伟\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "Journal of Power Sources， 286（2015）：258–263\n" +
                            "\n" +
                            "ISSN：0378-7753影响因子：6.217\n" +
                            "\n" +
                            "13\n" +
                            "\n" +
                            "Layer-by-layer structured nanofiber membranes with photoinduced self-cleaning functions\n" +
                            "\n" +
                            "王栋\n" +
                            "\n" +
                            "（1/6）\n" +
                            "\n" +
                            "The Journal of Physical Chemistry, Part C, 115（2011）, 6825-6832 ISSN:1932-7447影响因子：4.772\n" +
                            "\n" +
                            "14\n" +
                            "\n" +
                            "Stretchable conductive polyurethane elastomer in situ polymerized with multi-walled carbon nanotubes\n" +
                            "\n" +
                            "王栋\n" +
                            "\n" +
                            "（1/6）\n" +
                            "\n" +
                            "Journal of Materials Chemistry C，1（2013）, 2744-2749\n" +
                            "\n" +
                            "ISSN：0959-9428影响因子：4.696\n" +
                            "\n" +
                            "15\n" +
                            "\n" +
                            "High performance hybrid Al2O3/poly(vinyl alcohol-co-ethylene) nanofibrous membrane for lithium-ion battery separator\n" +
                            "\n" +
                            "刘琼珍\n" +
                            "\n" +
                            "（1/9）\n" +
                            "\n" +
                            "Electrochimica Acta, 176(2015): 949-955\n" +
                            "\n" +
                            "ISSN:: 0013-4686 影响因子：4.504\n" +
                            "\n" +
                            "16\n" +
                            "\n" +
                            "Catalytic generation of hydroxyl radicals by dioxygen-mediated oxidation of p-aminophenol by simple cobalt(II) ions in bicarbonate aqueous solution for use in Acid Orange 7 decolorization\n" +
                            "\n" +
                            "徐爱华\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "journal of chemistry，ISSN:1369-9261，2014，Vol.10 SCI\n" +
                            "\n" +
                            "17\n" +
                            "\n" +
                            "Efficient H2O2 Oxidation of Organic Dyes Catalyzed by Simple Copper(II) Ions in Bicarbonate Aqueous Solution\n" +
                            "\n" +
                            "徐爱华\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "industrial & engineering chemistry research ，ISSN: 0888-5885，2014，Vol.53，SCI\n" +
                            "\n" +
                            "18\n" +
                            "\n" +
                            "Manganese oxide octahedral molecular sieve (OMS-2) as an effective catalyst for degradation of organic dyes in aqueous solutions in the presence of peroxymonosulfateOriginal\n" +
                            "\n" +
                            "徐爱华\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "APPLIED CATALYSIS B-ENVIRONMENTAL，ISSN: 0926-3373，2015，Vol.164，SCI\n" +
                            "\n" +
                            "19\n" +
                            "\n" +
                            "Production of a value added compound from the H-acid wastewater—Bioflocculants by Klebsiella pneumoniae\n" +
                            "\n" +
                            "周建刚\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "Colloids and Surfaces B: Biointerfaces，ISSN: 0927-7765，2014,vol 12，SCI\n" +
                            "\n" +
                            "20\n" +
                            "\n" +
                            "Production of a bioflocculant from chromotropic acid waste waterand its application in steroid estrogen removal\n" +
                            "\n" +
                            "周建刚\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "Colloids and Surfaces B: Biointerfaces，ISSN: 0927-7765，2014,vol 12，SCI\n" +
                            "\n" +
                            "21\n" +
                            "\n" +
                            "Characterization of a bioflocculant MBF-5 by Klebsiella pneumoniae and its application in Acanthamoeba cysts removal\n" +
                            "\n" +
                            "周建刚\n" +
                            "\n" +
                            "（通讯作者）\n" +
                            "\n" +
                            "Bioresource Technology，ISSN: 0960-8524, 2013,vol 5，SCI\n" +
                            "\n" +
                            "22\n" +
                            "\n" +
                            "Removal of copper from acid wastewater of bioleaching by adsorption onto ramie residue and uptake by Trichoderma viride\n" +
                            "\n" +
                            "王布匀\n" +
                            "\n" +
                            "Bioresource Technology，ISSN: 0960-8524，2013,vol 8，SCI\n" +
                            "\n" +
                            "23\n" +
                            "\n" +
                            "Bioleaching of heavy metal from woody biochar using Acidithiobacillus ferrooxidans and activation for adsorption\n" +
                            "\n" +
                            "王布匀\n" +
                            "\n" +
                            "Bioresource Technology，ISSN: 0960-8524, 2013, vol 6，SCI\n" +
                            "\n" +
                            "24\n" +
                            "\n" +
                            "Degradation of disperse blue E-4R in aqueous solution by zero-va", "result", new String[]{})
            ));
        };
    }
}
