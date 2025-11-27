import{Ia as V,Ja as O,Ka as P,p as R,ra as L,wa as j}from"./chunk-4GW6BUX4.js";import{$ as U,Bb as E,Ha as S,Ia as w,Ja as T,Jb as z,La as h,P as x,Q as k,T as D,U as g,Vb as N,Yb as b,dc as v,hb as _,ka as l,nb as M}from"./chunk-ZS4RC7DI.js";var Z=`
    .p-inputtext {
        font-family: inherit;
        font-feature-settings: inherit;
        font-size: 1rem;
        color: dt('inputtext.color');
        background: dt('inputtext.background');
        padding-block: dt('inputtext.padding.y');
        padding-inline: dt('inputtext.padding.x');
        border: 1px solid dt('inputtext.border.color');
        transition:
            background dt('inputtext.transition.duration'),
            color dt('inputtext.transition.duration'),
            border-color dt('inputtext.transition.duration'),
            outline-color dt('inputtext.transition.duration'),
            box-shadow dt('inputtext.transition.duration');
        appearance: none;
        border-radius: dt('inputtext.border.radius');
        outline-color: transparent;
        box-shadow: dt('inputtext.shadow');
    }

    .p-inputtext:enabled:hover {
        border-color: dt('inputtext.hover.border.color');
    }

    .p-inputtext:enabled:focus {
        border-color: dt('inputtext.focus.border.color');
        box-shadow: dt('inputtext.focus.ring.shadow');
        outline: dt('inputtext.focus.ring.width') dt('inputtext.focus.ring.style') dt('inputtext.focus.ring.color');
        outline-offset: dt('inputtext.focus.ring.offset');
    }

    .p-inputtext.p-invalid {
        border-color: dt('inputtext.invalid.border.color');
    }

    .p-inputtext.p-variant-filled {
        background: dt('inputtext.filled.background');
    }

    .p-inputtext.p-variant-filled:enabled:hover {
        background: dt('inputtext.filled.hover.background');
    }

    .p-inputtext.p-variant-filled:enabled:focus {
        background: dt('inputtext.filled.focus.background');
    }

    .p-inputtext:disabled {
        opacity: 1;
        background: dt('inputtext.disabled.background');
        color: dt('inputtext.disabled.color');
    }

    .p-inputtext::placeholder {
        color: dt('inputtext.placeholder.color');
    }

    .p-inputtext.p-invalid::placeholder {
        color: dt('inputtext.invalid.placeholder.color');
    }

    .p-inputtext-sm {
        font-size: dt('inputtext.sm.font.size');
        padding-block: dt('inputtext.sm.padding.y');
        padding-inline: dt('inputtext.sm.padding.x');
    }

    .p-inputtext-lg {
        font-size: dt('inputtext.lg.font.size');
        padding-block: dt('inputtext.lg.padding.y');
        padding-inline: dt('inputtext.lg.padding.x');
    }

    .p-inputtext-fluid {
        width: 100%;
    }
`;var pt=`
    ${Z}

    /* For PrimeNG */
   .p-inputtext.ng-invalid.ng-dirty {
        border-color: dt('inputtext.invalid.border.color');
    }

    .p-inputtext.ng-invalid.ng-dirty::placeholder {
        color: dt('inputtext.invalid.placeholder.color');
    }
`,ct={root:({instance:t})=>["p-inputtext p-component",{"p-filled":t.$filled(),"p-inputtext-sm":t.pSize==="small","p-inputtext-lg":t.pSize==="large","p-invalid":t.invalid(),"p-variant-filled":t.$variant()==="filled","p-inputtext-fluid":t.hasFluid}]},$=(()=>{class t extends L{name="inputtext";theme=pt;classes=ct;static \u0275fac=(()=>{let n;return function(r){return(n||(n=l(t)))(r||t)}})();static \u0275prov=x({token:t,factory:t.\u0275fac})}return t})();var Nt=(()=>{class t extends V{ngControl=g(j,{optional:!0,self:!0});pcFluid=g(O,{optional:!0,host:!0,skipSelf:!0});pSize;variant=b();fluid=b(void 0,{transform:v});invalid=b(void 0,{transform:v});$variant=N(()=>this.variant()||this.config.inputStyle()||this.config.inputVariant());_componentStyle=g($);ngAfterViewInit(){super.ngAfterViewInit(),this.writeModelValue(this.ngControl?.value??this.el.nativeElement.value),this.cd.detectChanges()}ngDoCheck(){this.writeModelValue(this.ngControl?.value??this.el.nativeElement.value)}onInput(){this.writeModelValue(this.ngControl?.value??this.el.nativeElement.value)}get hasFluid(){return this.fluid()??!!this.pcFluid}static \u0275fac=(()=>{let n;return function(r){return(n||(n=l(t)))(r||t)}})();static \u0275dir=T({type:t,selectors:[["","pInputText",""]],hostVars:2,hostBindings:function(o,r){o&1&&M("input",function(u){return r.onInput(u)}),o&2&&E(r.cx("root"))},inputs:{pSize:"pSize",variant:[1,"variant"],fluid:[1,"fluid"],invalid:[1,"invalid"]},features:[z([$]),h]})}return t})(),Rt=(()=>{class t{static \u0275fac=function(o){return new(o||t)};static \u0275mod=w({type:t});static \u0275inj=k({})}return t})();var Q="3.7.8",ft=Q,d=typeof Buffer=="function",J=typeof TextDecoder=="function"?new TextDecoder:void 0,G=typeof TextEncoder=="function"?new TextEncoder:void 0,xt="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",p=Array.prototype.slice.call(xt),m=(t=>{let e={};return t.forEach((n,o)=>e[n]=o),e})(p),gt=/^(?:[A-Za-z\d+\/]{4})*?(?:[A-Za-z\d+\/]{2}(?:==)?|[A-Za-z\d+\/]{3}=?)?$/,i=String.fromCharCode.bind(String),K=typeof Uint8Array.from=="function"?Uint8Array.from.bind(Uint8Array):t=>new Uint8Array(Array.prototype.slice.call(t,0)),W=t=>t.replace(/=/g,"").replace(/[+\/]/g,e=>e=="+"?"-":"_"),X=t=>t.replace(/[^A-Za-z0-9\+\/]/g,""),tt=t=>{let e,n,o,r,a="",u=t.length%3;for(let f=0;f<t.length;){if((n=t.charCodeAt(f++))>255||(o=t.charCodeAt(f++))>255||(r=t.charCodeAt(f++))>255)throw new TypeError("invalid character found");e=n<<16|o<<8|r,a+=p[e>>18&63]+p[e>>12&63]+p[e>>6&63]+p[e&63]}return u?a.slice(0,u-3)+"===".substring(u):a},B=typeof btoa=="function"?t=>btoa(t):d?t=>Buffer.from(t,"binary").toString("base64"):tt,C=d?t=>Buffer.from(t).toString("base64"):t=>{let n=[];for(let o=0,r=t.length;o<r;o+=4096)n.push(i.apply(null,t.subarray(o,o+4096)));return B(n.join(""))},y=(t,e=!1)=>e?W(C(t)):C(t),ht=t=>{if(t.length<2){var e=t.charCodeAt(0);return e<128?t:e<2048?i(192|e>>>6)+i(128|e&63):i(224|e>>>12&15)+i(128|e>>>6&63)+i(128|e&63)}else{var e=65536+(t.charCodeAt(0)-55296)*1024+(t.charCodeAt(1)-56320);return i(240|e>>>18&7)+i(128|e>>>12&63)+i(128|e>>>6&63)+i(128|e&63)}},bt=/[\uD800-\uDBFF][\uDC00-\uDFFFF]|[^\x00-\x7F]/g,et=t=>t.replace(bt,ht),Y=d?t=>Buffer.from(t,"utf8").toString("base64"):G?t=>C(G.encode(t)):t=>B(et(t)),s=(t,e=!1)=>e?W(Y(t)):Y(t),q=t=>s(t,!0),mt=/[\xC0-\xDF][\x80-\xBF]|[\xE0-\xEF][\x80-\xBF]{2}|[\xF0-\xF7][\x80-\xBF]{3}/g,yt=t=>{switch(t.length){case 4:var e=(7&t.charCodeAt(0))<<18|(63&t.charCodeAt(1))<<12|(63&t.charCodeAt(2))<<6|63&t.charCodeAt(3),n=e-65536;return i((n>>>10)+55296)+i((n&1023)+56320);case 3:return i((15&t.charCodeAt(0))<<12|(63&t.charCodeAt(1))<<6|63&t.charCodeAt(2));default:return i((31&t.charCodeAt(0))<<6|63&t.charCodeAt(1))}},nt=t=>t.replace(mt,yt),ot=t=>{if(t=t.replace(/\s+/g,""),!gt.test(t))throw new TypeError("malformed base64.");t+="==".slice(2-(t.length&3));let e,n,o,r=[];for(let a=0;a<t.length;)e=m[t.charAt(a++)]<<18|m[t.charAt(a++)]<<12|(n=m[t.charAt(a++)])<<6|(o=m[t.charAt(a++)]),n===64?r.push(i(e>>16&255)):o===64?r.push(i(e>>16&255,e>>8&255)):r.push(i(e>>16&255,e>>8&255,e&255));return r.join("")},F=typeof atob=="function"?t=>atob(X(t)):d?t=>Buffer.from(t,"base64").toString("binary"):ot,rt=d?t=>K(Buffer.from(t,"base64")):t=>K(F(t).split("").map(e=>e.charCodeAt(0))),it=t=>rt(at(t)),vt=d?t=>Buffer.from(t,"base64").toString("utf8"):J?t=>J.decode(rt(t)):t=>nt(F(t)),at=t=>X(t.replace(/[-_]/g,e=>e=="-"?"+":"/")),A=t=>vt(at(t)),Ct=t=>{if(typeof t!="string")return!1;let e=t.replace(/\s+/g,"").replace(/={0,2}$/,"");return!/[^\s0-9a-zA-Z\+/]/.test(e)||!/[^\s0-9a-zA-Z\-_]/.test(e)},st=t=>({value:t,enumerable:!1,writable:!0,configurable:!0}),dt=function(){let t=(e,n)=>Object.defineProperty(String.prototype,e,st(n));t("fromBase64",function(){return A(this)}),t("toBase64",function(e){return s(this,e)}),t("toBase64URI",function(){return s(this,!0)}),t("toBase64URL",function(){return s(this,!0)}),t("toUint8Array",function(){return it(this)})},ut=function(){let t=(e,n)=>Object.defineProperty(Uint8Array.prototype,e,st(n));t("toBase64",function(e){return y(this,e)}),t("toBase64URI",function(){return y(this,!0)}),t("toBase64URL",function(){return y(this,!0)})},At=()=>{dt(),ut()},c={version:Q,VERSION:ft,atob:F,atobPolyfill:ot,btoa:B,btoaPolyfill:tt,fromBase64:A,toBase64:s,encode:s,encodeURI:q,encodeURL:q,utob:et,btou:nt,decode:A,isValid:Ct,fromUint8Array:y,toUint8Array:it,extendString:dt,extendUint8Array:ut,extendBuiltins:At};var I="AuthToken",lt=class t{constructor(e){this.router=e}roles=[];setToken(e){window.sessionStorage.removeItem(I),window.sessionStorage.setItem(I,e)}getToken(){return sessionStorage.getItem(I)}getRoles(){if(!this.isLogged())return this.logout(),null;let e=this.getToken();if(!e)return this.logout(),null;let n=e.split(".")[1],o=c.decode(n);return JSON.parse(o).roles}isLogged(){return this.getToken()!=null}getNameUser(){if(!this.isLogged())return this.logout(),null;let e=this.getToken();if(!e)return this.logout(),null;let n=e.split(".")[1],o=c.decode(n);return JSON.parse(o).nombreUsuario}getIdUser(){if(!this.isLogged())return this.logout(),null;let e=this.getToken();if(!e)return this.logout(),null;let n=e.split(".")[1],o=c.decode(n);return JSON.parse(o).nId}getUser(){if(!this.isLogged())return this.logout(),null;let e=this.getToken();if(!e)return this.logout(),null;let n=e.split(".")[1],o=c.decode(n);return JSON.parse(o).sub}logout(){window.sessionStorage.clear(),this.router.navigate([""])}static \u0275fac=function(n){return new(n||t)(D(R))};static \u0275prov=x({token:t,factory:t.\u0275fac,providedIn:"root"})};var Bt=["data-p-icon","check"],$t=(()=>{class t extends P{static \u0275fac=(()=>{let n;return function(r){return(n||(n=l(t)))(r||t)}})();static \u0275cmp=S({type:t,selectors:[["","data-p-icon","check"]],features:[h],attrs:Bt,decls:1,vars:0,consts:[["d","M4.86199 11.5948C4.78717 11.5923 4.71366 11.5745 4.64596 11.5426C4.57826 11.5107 4.51779 11.4652 4.46827 11.4091L0.753985 7.69483C0.683167 7.64891 0.623706 7.58751 0.580092 7.51525C0.536478 7.44299 0.509851 7.36177 0.502221 7.27771C0.49459 7.19366 0.506156 7.10897 0.536046 7.03004C0.565935 6.95111 0.613367 6.88 0.674759 6.82208C0.736151 6.76416 0.8099 6.72095 0.890436 6.69571C0.970973 6.67046 1.05619 6.66385 1.13966 6.67635C1.22313 6.68886 1.30266 6.72017 1.37226 6.76792C1.44186 6.81567 1.4997 6.8786 1.54141 6.95197L4.86199 10.2503L12.6397 2.49483C12.7444 2.42694 12.8689 2.39617 12.9932 2.40745C13.1174 2.41873 13.2343 2.47141 13.3251 2.55705C13.4159 2.64268 13.4753 2.75632 13.4938 2.87973C13.5123 3.00315 13.4888 3.1292 13.4271 3.23768L5.2557 11.4091C5.20618 11.4652 5.14571 11.5107 5.07801 11.5426C5.01031 11.5745 4.9368 11.5923 4.86199 11.5948Z","fill","currentColor"]],template:function(o,r){o&1&&(U(),_(0,"path",0))},encapsulation:2})}return t})();export{Nt as a,Rt as b,$t as c,lt as d};
