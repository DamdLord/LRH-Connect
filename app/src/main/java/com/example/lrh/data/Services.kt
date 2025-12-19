package com.example.lrh.data

object Services{
    val mtnService = listOf(
        "50MB  N120  30days",
        "1GB  N230  30days",
        "2GB  N430  30days",
        "3GB  N530  30days",
        "4GB  N630  30days",
        "5GB  N730  30days",
        "8GB  N830  30days",
        "10GB  N930  30days"
    )
    val gloService = listOf(
        "500MB  N230  30days",
        "1GB  N230  30days",
        "2GB  N230  30days",
        "3GB  N230  30days",
        "4GB  N230  30days",
        "5GB  N230  30days",
        "6GB  N230  30days",
        "7GB  N230  30days",
    )
    val nineMobileService = listOf<String>(
        "500MB  N230  30days",
        "1GB  N230  30days",
        "2GB  N230  30days",
        "3GB  N230  30days",
        "4GB  N230  30days",
        "5GB  N230  30days",
        "8GB  N230  30days",
        "10GB  N230  30days",
    )
    val airtelService = listOf(
        "500MB  N120  30days",
        "1GB  N230  30days",
        "2GB  N430  30days",
        "3GB  N530  30days",
        "4GB  N630  30days",
        "5GB  N730  30days",
        "8GB  N830  30days",
        "10GB  N930  30days",
    )

}

object NetworkList{
    val networkList = listOf("Select Network","MTN", "AIRTEL", "9MOBILE", "GLO")

}

object AirtimeType{
    val airtimeTypeList = listOf("VTU", "Share And Sell")
}

object DataType{
    val MTNDataTypeList = listOf("select type", "SME", "Gifting", "CG","SME PLUS")
    val AirtelDataType = listOf("Select Type", "Gifting", "Corporate")
    val GLODtaType = listOf("Select Type", "Corporate Gifting", "Gifting", "GLO AWOOF")
    val NineMobileDtaType = listOf("Select Type", "Corporate")
}
object DataPlan{
    val dataPlanList = listOf("select plan", "", "")
}
object MeterType{
    val meterTypeList = listOf("Select type", "Prepaid", "Postpaid")
}

object DataPlanList{
    val mtnSME = listOf(
        "Select Plan",
        "1GB SME 1 MONTH - ₦680",
        "2GB SME 1 MONTH - ₦1350",
        "3GB SME 1 MONTH - ₦1989",
        "5GB SME 1 MONTH - ₦3300",
        "10GB SME 1 MONTH - ₦5050",
    )
    val mtnSmePlus = listOf(
        ""
    )
    val mtnGifting = listOf(
        "Select Plan",
        "MTN Gifting 750MB 3 DAYS - ₦480",
        "MTN Gifting 1GB 7 DAYS - ₦850",
        "MTN Gifting 2GB 1 MONTH - ₦1580",
        "MTN Gifting 1GB 1 DAY AWOOF DATA- ₦550",
        "MTN Gifting 1.5GB ₦600 2 DAYS AWOOF DATA - ₦650",
        "MTN Gifting 2GB 2 DAYS AWOOF DATA - ₦850"

    )

    val ntnCorporate = listOf(
        "Select Plan",
        "500MB Corporate 1 MONTH - ₦450",
        "1GB Corporate 1 MONTH - ₦750",
        "2GB Corporate 1 MONTH - ₦1350",
        "3GB Corporate 1 MONTH - ₦1850",
        "5GB Corporate 1 MONTH - ₦3050",
    )
    val airtelGifting = listOf(
        "Select Plan",
        "AIRTEL GIFTING 1GB 3DAYS AWOOF DATA - ₦480",
        "AIRTEL GIFTING 2GB 2DAYS AWOOF DATA - ₦680",
        "AIRTEL GIFTING 3GB 2DAYS AWOOF DATA - ₦1200",
        "AIRTEL GIFTING 7GB 1MONTH AWOOF DATA - ₦2200",
        "AIRTEL GIFTING 10GB 1MONTH AWOOF DATA - ₦3250",
    )
    val airtelCorporate = listOf(
        "Select Plan",
        "AIRTEL CG 500MB 1MONTH - ₦550",
        "AIRTEL CG 1GB 7DAYS - ₦850",
        "AIRTEL CG 2GB 1MONTH - ₦1550",
        "AIRTEL CG 3GB 1MONTH - ₦2000",

    )
    val gloGifting= listOf(
        "Select Plan",
        "GLO GIFTING 750MB 1DAY AWOOF DATA - ₦250",
        "GLO GIFTING 1.5GB 1DAY AWOOF DATA - ₦350",
        "GLO GIFTING 2.5MB 2DAYS AWOOF DATA - ₦550",
        "GLO GIFTING 10MB 7DAYS AWOOF DATA - ₦2050"
    )
    val gloCorporate = listOf(
        "Select Plan",
        "GLO CG 500MB 30 DAYS - ₦350",
        "GLO CG 200MB 14 DAYS - ₦250",
        "GLO CG 10B 1 MONTH - ₦4350",
        "GLO CG 1GB 1 MONTH - ₦450",
        "GLO CG 2GB 1 MONTH - ₦880",
        "GLO CG 3GB 1 MONTH - ₦1320",
        "GLO CG 5GB 1 MONTH - ₦2180",
        "GLO CG 1GB 7 DAYS - ₦315",
        "GLO CG 3GB 7 DAYS - ₦920",
        "GLO CG 5GB 7 DAYS - ₦1520",
        "GLO CG 1GB 3 DAYS - ₦278",
        "GLO CG 3GB 30 DAYS - ₦790"
    )
    val gloAwoof = listOf(
        ""
    )
    val nineMobileCorporate = listOf(
        "Select Plan",
    )
}

object CableTvProviderServiceList{
    val GOTVServiceList = listOf(
        "GOTV LITE/₦1575/MONTH",
        "GOTV JINJA/₦3300/MONTH",
        "GOTV JOLLI/₦4850/MONTH",
        "GOTV MAX/₦7200/MONTH",
        "GOTV SUPA/₦9600/MONTH",
        "GOTV SUPA PLUS/₦15700/MONTH"
    )
    val DSTVServiceList = listOf(
        "DSTV PADI/₦3600/MONTH",
        "DSTV YANGA/₦5100/MONTH",
        "DSTV CONFAM/₦9300/MONTH",
        "DSTV COMPACT/₦15700/MONTH",
        "DSTV COMPACT PLUS/₦25000/MONTH",
        "DSTV COMPACT PLUS+XtraView/₦30000/MONTH"
    )
    val STARTIMESServiceList = listOf(
        "DTH NOVA/₦1900/MONTH",
        "DTT NOVA/₦1900/MONTH",
        "DTT BASIC/₦3700/MONTH",
        "DTH BASIC/₦4700/MONTH",
        "DTT CLASSIC/₦5500/MONTH"
    )
}

object CableTvProvider{
    val providerList = listOf("Select Provider", "GOTV", "DSTV", "STARTIMES")
}

object SubscriptionType{
    val subscriptionTypeList = listOf("Subscription type", "Change", "Renew")
}
object Discos{
    val discosProviderList = listOf("Select Disco", "ABUJA ELECTRICITY", "EKO ELECTRICITY",
        "KADUNA ELECTRICITY", "KANO ELECTRICITY", "JOS ELECTRICITY",
        "IKEJA ELECTRICITY", "IBADAN ELECTRICITY", "PORT HARCOURT ELECTRICITY", "BENIN ELECTRICITY", "YOLA ELECTRICITY"
    )
}



object DataTypeForDataPins{
    val dataTypeList = listOf("Select type", "SME", "Gifting", "Corporate")
}

object ExamType{
    val examTypeList = listOf("Select type", "WAEC", "NECO", "NABTEB")
}
object States{
    val  listOfStates = listOf(
        "State", "Abuja FCT","Abia", "Adamawa", "Akwa Ibom", "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno", "Cross River", "Delta", "Ebonyi",
        "Edo", "Ekiti", "Enugu", "Gombe", "Imo", "Jigawa", "Kaduna", "Kano", "Kastina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nassarawa", "Niger",
        "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto", "Taraba", "Yobe", "Zamfara"
    )
}