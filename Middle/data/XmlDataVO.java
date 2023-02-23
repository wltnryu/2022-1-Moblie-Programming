public class XmlDataVO {
 private String createDt;
 private String deathCnt;
 private String defCnt;
 private String gubun;
 private String gubunCn;
 private String gubunEn;
 private String incDec;
 // private String isolClearCnt; - 2022년 02월 23일까지만 존재하는 데이터
 private String localOccCnt;
 private String overFlowCnt;
 private String qurRate;
 private String seq;
 private String stdDay;
 private String updateDt;
 
 public XmlDataVO(String createDt, String deathCnt, String defCnt, String gubun, 
		 String gubunCn, String gubunEn, String incDec, /* String isolClearCnt, */
		 String localOccCnt, String overFlowCnt, String qurRate,  
		 String seq, String stdDay, String updateDt) {
  super();
  this.createDt = createDt;
  this.gubun = gubun;
  this.seq = seq;
  this.deathCnt = deathCnt;
  this.gubunCn = gubunCn;
  this.gubunEn = gubunEn;
  this.incDec = incDec;
  // this.isolClearCnt = isolClearCnt; - 2022년 02월 23일까지만 존재하는 데이터
  this.qurRate = qurRate;
  this.stdDay = stdDay;
  this.updateDt = updateDt;
  this.defCnt = defCnt;
  this.overFlowCnt = overFlowCnt;
  this.localOccCnt = localOccCnt;
 }
 
 public String getcreateDt() {
  return createDt;
 }
 public void setcreate_dt(String createDt) {
  this.createDt = createDt;
 }
 public String getgubun() {
  return gubun;
 }
 public void setgubun(String gubun) {
  this.gubun = gubun;
 }
 public String getseq() {
  return seq;
 }
 public void setseq(String seq) {
  this.seq = seq;
 }
 public String getdeathCnt() {
  return deathCnt;
 }
 public void setdeathCnt(String deathCnt) {
  this.deathCnt = deathCnt;
 }
 public String getgubunCn() {
	  return gubunCn;
	  }
 public void setgubunCn(String gubunCn) {
	  this.gubunCn = gubunCn;
	 }
 public String getgubunEn() {
	  return gubunEn;
	 }
public void setgubunEn(String gubunEn) {
	  this.gubunEn = gubunEn;
	 }
public String getincDec() {
	  return incDec;
	 }
public void setincDec(String incDec) {
	  this.incDec = incDec;
	 }
/* - 2022년 02월 23일까지만 존재하는 데이터
public String getisolClearCnt() {
	  return isolClearCnt;
	 }
public void setisolClearCnt(String isolClearCnt) {
	  this.isolClearCnt = isolClearCnt;
	 }
	 */
public String getqurRate() {
	  return qurRate;
	 }
public void setqurRate(String qurRate) {
	  this.qurRate = qurRate;
	 }
public String getstdDay() {
	  return stdDay;
	 }
public void setstdDay(String stdDay) {
	  this.stdDay = stdDay;
	 }
public String getupdateDt() {
	  return updateDt;
	 }
public void setupdateDt(String updateDt) {
	  this.updateDt = updateDt;
	 }
public String getdefCnt() {
	  return defCnt;
	 }
public void setdefCnt(String defCnt) {
	  this.defCnt = defCnt;
	 }
public String getoverFlowCnt() {
	  return overFlowCnt;
	 }
public void setoverFlowCnt(String overFlowCnt) {
	  this.overFlowCnt = overFlowCnt;
	 }
public String getlocalOccCnt() {
	  return localOccCnt;
	 }
public void setlocalOccCnt(String localOccCnt) {
	  this.localOccCnt = localOccCnt;
	 }
} 
