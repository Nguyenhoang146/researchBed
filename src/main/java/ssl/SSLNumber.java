package ssl;
/* Generated By:JJTree: Do not edit this line. SSLNumber.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=SSL,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class SSLNumber extends SimpleNode {
  public SSLNumber(int id) {
    super(id);
  }

  public SSLNumber(ExpressionParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public String jjtAccept(ExpressionParserVisitor visitor, String data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=a966f669c5cf1e21f38457880fc073e3 (do not edit this line) */